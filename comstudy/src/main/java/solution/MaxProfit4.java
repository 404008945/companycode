package solution;

public class MaxProfit4 {

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res1 = 0;
        int res2 = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Integer.MAX_VALUE;
            res1 = res2 =0;
            //需要控制前后
            for (int j = 0; j <= i; j++) {
                min = Math.min(min, prices[j]);
                res1  = Math.max(res1, prices[j]-min);
            }
            min = Integer.MAX_VALUE;
            for (int k = i + 1; k < prices.length; k++) {
                min = Math.min(min, prices[k]);
                res2 = Math.max(res2, prices[k]-min);
            }
            res = Math.max(res,res1 + res2);
        }
        return res;
    }

    public static void main(String[] args) {
        int a[] = {3,3,5,0,0,3,1,4};
        maxProfit(a);

    }
}
