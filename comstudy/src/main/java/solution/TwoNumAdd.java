package solution;

import java.util.*;

public class TwoNumAdd {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mark = new HashMap<>();
        int [] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(mark.containsKey(nums[i])){
                ans[0] = mark.get(nums[i]);
                ans[1] = i;
                return ans;
            }
            mark.put(target - nums[i],i);
        }
         return  ans ;
    }

    //减掉了一重循环
    public static List<List<Integer>> threeSum(int[] nums) {
        //双重循环+hash
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>=1&&nums[i] == nums[i-1]){
                continue;
            }
            HashSet set = new HashSet();//存需要的第三数
            int sucessI=-1;
            for(int j = i+1;j<nums.length;j++)
            {
                if (set.contains(nums[j])&&(sucessI ==-1||nums[j] != nums[sucessI])) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(nums[i]);
                    ans.add(0-nums[i]-nums[j]);
                    ans.add(nums[j]);
                    lists.add(ans);
                    sucessI = j;
                }
                int val = 0 - nums[i] - nums[j];//目标值
                set.add(val);
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        //采用双指针法
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            int val = 0 - nums[i];
            //双指针求解
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                if(nums[left] + nums[right]==val){
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


    public static void main(String[] args) {

        int a[] ={0,0,0,0};

        System.out.println(threeSum2(a));
    }
}
