package solution;

public class MaxProfit3 {

    //1, 3, 2, 8, 4, 9         2
    //能赚就卖行不行？
    public int maxProfit(int[] prices, int fee) {
        if(prices.length == 0){
            return 0;
        }

        int profit =0;
        for(int i= 1;i<prices.length;i++){
            if(prices[i]>prices[i]+fee){
                profit += prices[i] - prices[i] - fee;
            }
        }
        return profit;
    }
}
