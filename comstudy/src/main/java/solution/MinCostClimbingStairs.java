package solution;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        if(cost.length == 0){
            return 0;
        }
        if(cost.length == 1){
            return cost[0];
        }
        if(cost.length == 2){
            return Math.min(cost[0],cost[1]);
        }
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i<=cost.length-1;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    public static void main(String[] args) {

        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));

    }


}
