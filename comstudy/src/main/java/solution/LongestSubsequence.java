package solution;

import java.util.*;

public class LongestSubsequence {
    public static int longestSubsequence(int[] arr, int difference) {
        //dp[i]代表的是数字，不再是位置 整数从小到大打表，负数反之
        if(arr.length == 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        //dp[i]代表以arr[i]结尾的最长等差数组
        int ans = 1;
        List<Integer> list = new ArrayList();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        for(int i=0;i< list.size();i++){
                map.put(arr[i],1);
                Integer val = map.get(list.get(i)-difference);
                if(val !=null){
                    map.put(list.get(i),val+1);
                    ans = Math.max(ans,val+1);
                }

        }
        return ans;
    }

    public static void main(String[] args) {
        longestSubsequence(new int[]{-6,6,-8,0,7,-8,5,-7,10,-10},-6);
    }
}
