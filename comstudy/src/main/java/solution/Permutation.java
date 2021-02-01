package solution;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {

    static Set<String> set = new HashSet<>();

    //每次搜索，都搜全部
    static void dfs(String s,StringBuilder val,boolean vis[]){
        if (val.length() >= s.length()) {
            set.add(val.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(vis[i]){
                continue;
            }
            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && !vis[i - 1])
                continue;
            vis[i] = true;
            //随便挑一个
            val.append(s.charAt(i));
            dfs(s,val,vis);
            val.deleteCharAt(val.length()-1);
            vis[i] = false;
        }
    }

    //qqe,对下标进行全排列
    static  public String[] permutation(String S) {
        dfs(S,new StringBuilder(),new boolean[S.length()]);
        int i = 0;
        String[] strings = new String[set.size()];
        for(String s:set){
            strings[i++] = s;
        }
        return strings;
    }

    public static void main(String[] args) {
        permutation("qqe");
    }
}
