package solution;

import java.util.Arrays;

public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for(int i = 0;i<g.length;i++){
            if(index>=s.length){
                break;
            }
            while(s[index]<g[i]){
                index++;
            }
            count++;
            index++;
        }
        return count;
    }
    /**
     * 公司
     */
}
