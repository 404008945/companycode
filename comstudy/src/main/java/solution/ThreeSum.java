package solution;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int val = 0 - nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (val == nums[left] + nums[right]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    lists.add(ans);
                    left++;
                    right--;
                }

                if(nums[left] + nums[right]<val){
                    left++;
                }
                if(nums[left] + nums[right]>val){
                    right--;
                }
                while (left>i+1&&left<nums.length&&nums[left] == nums[left-1]){
                    left++;
                }
                while (right<nums.length-1&&right>=0&&nums[right] == nums[right+1]){
                    right--;
                }
            }
        }
        return lists;

    }
}
