package solution;

import java.util.Arrays;

public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //处理左右两端
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],nums[nums.length-1]*nums[0]*nums[1]);
    }

    public static void main(String[] args) {

    }
}
