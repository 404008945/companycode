package string;

import java.util.Arrays;



public class MinimumOperations {
    /**
     *
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        int R[] = new int[leaves.length()];
        int R_Y[] = new int[leaves.length()];
        int R_Y_R[] = new int[leaves.length()];
        Arrays.fill(R,Integer.MAX_VALUE);
        Arrays.fill(R_Y,Integer.MAX_VALUE);
        Arrays.fill(R_Y_R,Integer.MAX_VALUE);
        if(leaves.charAt(0) == 'r'){
            R[0] = 0;
        }else{
            R[0] = 1;
        }
        for (int i = 1; i < leaves.length(); i++) {
            if(leaves.charAt(i) == 'r'){
                R[i] = R[i-1];
                R_Y[i] = Math.min(R[i-1],R_Y[i-1])+1;
                R_Y_R[i] = Math.min(R_Y_R[i-1],R_Y[i-1]);
            }else{
                R[i] = R[i-1]+1;
                R_Y[i] = Math.min(R[i-1],R_Y[i-1]);
                R_Y_R[i] = Math.min(R_Y_R[i-1],R_Y[i-1])+1;
            }

        }
          return R_Y_R[leaves.length()-1];
    }
}
