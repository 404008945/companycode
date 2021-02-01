package solution;

import java.util.ArrayList;
import java.util.List;

public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int num =0;

        for(int i = 0;i<A.length;i++){
            num = num * 2;
            num += A[i];
            num%=10;
            if(num ==0 || num == 5){
                ans.add(true);
            }else {
                ans.add(false);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
