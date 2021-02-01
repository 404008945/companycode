package solution;

import java.util.*;

public class MinSumOfLengths {
    //子数组，就是连续区间
    public static int minSumOfLengths(int[] arr, int target) {
       Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
       int dp[]=new int[arr.length+1]; //dp[i] 表示i之前 的最短长度 dp[i] = min(dp[i-1],i-pos)  ，dp从1开始、
        //dp[i] 表示 0  到 i-1 相加 = target最短长度
       Arrays.fill(dp,9999999);

       int sum = arr[0];
       int ans = Integer.MAX_VALUE;
       for(int i = 1;i<=arr.length;i++){
           sum += arr[i-1];
           int temp = sum - target;
           dp[i] = dp[i-1];
           if(map.get(temp)!=null){
               int pos= map.get(temp);
               int cur = i-pos;
               if(pos == 0&&temp == 0){
                   cur++;
               }
               dp[i] = Math.min(dp[i],cur);
               ans = Math.min(ans,  cur + dp[pos]);
           }
           map.put(sum,i);
       }
       return ans > 9999999?-1:ans;

    }
    public static void main(String[] args) {

        int arr [] = {2,2,4,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

                    //4 7 9 6 2
        System.out.println(minSumOfLengths(arr,20));

    }
}
