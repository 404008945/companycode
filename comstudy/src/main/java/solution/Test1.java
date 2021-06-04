package solution;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 找出最长对称字符串
 * 
 * @author liuxishan
 *
 */
public class Test1 {

	public static void main(String[] args) {
		// TODO 输出最长对称字符串：goog
		String input1 = "google";
		System.out.println(resolve(input1));
		// TODO 输出3个最长对称字符串：aba/aca/ada
		String input2 = "abcda";
		System.out.println(resolve(input2));
		// TODO 输出2个最长对称字符串：pop/upu，不会输出特殊字符的对称字符串p-p
		String input3 = "pop-upu";
		System.out.println(resolve(input3));
	}

	//对称，两端相等，以新的两端为起点再次寻找新的相等两端，递归寻找，寻找两端需满足最远距离
	public static void findMaxArea(String str, int start, int end, String head, String tail, Set<String> ans) {
		if (start == end) {
			ans.add(head + str.charAt(start) + tail);
			return;
		}
		if (start > end) {
			ans.add(head + tail);
			return;
		}
		int maxLen = 0;//先求出最大长度
		for (int i = start; i <= end; i++) {
			int j = findLastIndex(i, str, start, end);
			maxLen = Math.max(maxLen,j-i);
		}
		if(maxLen == 0){
			for (int i = start; i <= end; i++) {
				findMaxArea(str, i , i, head, tail, ans);
			}
			return;
		}
		for (int i = start; i <= end; i++) {
			int j = findLastIndex(i, str, start, end);
			if(j-i==maxLen) {
				String s1 = head + str.charAt(i);
				String s2 = str.charAt(j) + tail;
				findMaxArea(str, i + 1, j - 1, s1, s2, ans);
			}
		}
	}
	private static String[] stringFilter(String str) {
		String regEx = "[^a-zA-Z0-9]";
		Pattern p = Pattern.compile(regEx);
		return p.split(str);
	}
	public static String resolve(String input) {
		String[] prepare = stringFilter(input);
		StringBuilder ans = new StringBuilder();
		for (String str : prepare) {
		    Set<String> res = new HashSet<>();
		    findMaxArea(str,0,str.length()-1,"","",res);
		    for(String s:res) {
				ans.append(s);
				ans.append("/");
			}
		}
		return ans.substring(0, ans.length()-1);
	}

	private static int findLastIndex(int index,String str,int  start,int end){
		for(int i =end;i>=start;i--){
			if(str.charAt(i)  == str.charAt(index)){
				return i;
			}
		}
		return index;
	}
}
