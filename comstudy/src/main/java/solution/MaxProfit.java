package solution;

public class MaxProfit {

    //多次的话，赚了就卖，能赚就卖掉
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit =0;
        for(int i= 0;i<prices.length;i++){
            min = Math.min(min,prices[i]);
            if (i > 0) {
                profit = Math.max(profit,prices[i] - min);
            }
        }
        return profit;
    }


    public int maxProfits(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        //dp F[i]//代表当前赚的最大值，
        int trade = prices[0];
        int profit =0;
        for(int i= 1;i<prices.length;i++){
            if(prices[i]>trade){
                profit += prices[i] - trade;
            }
            trade = prices[i];
        }
        return profit;
    }
}
