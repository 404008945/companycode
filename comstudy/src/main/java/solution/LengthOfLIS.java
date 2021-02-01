package solution;

import java.util.Arrays;

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        int F[] = new  int[nums.length];
        Arrays.fill(F,1);
        for(int i = 1;i<nums.length;i++){
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    F[i] =Math.max(F[j]+1,F[i]);
                }
            }
        }
        int res = 0;
        for(Integer i:F) {
            res = Math.max(res,i);
        }
        return res;
    }

    public static void main(String[] args) {
        lengthOfLIS(new int[]{4,10,4,3,8,9});
    }
}
