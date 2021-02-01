package solution;

public class
Rob {

    public synchronized int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        int F[] = new int[nums.length];
        F[0] = nums[0];
        F[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            F[i] = Math.max(F[i-1],F[i-2]+nums[i]);
        }

        return F[nums.length-1];
    }
}
