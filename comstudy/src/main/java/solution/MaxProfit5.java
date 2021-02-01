package solution;

public class MaxProfit5 {
    public int maxProfit(int[] prices, int fee) {
        int dp1 [] = new int[prices.length];//没股票          今天 买或者不买，F[i] = max(sF[i-1],sF[i-1]-p);
        int dp2 [] = new int[prices.length];//有股票         今天 卖或者不卖 F[i] = max(bF[i-1],bF[i-1]+p-fee);
        //首位如何处理
        dp1[0] = 0;
        dp2[0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp1[i] = Math.max(dp1[i-1],dp2[i-1]+prices[i]-fee);//不持股
            dp2[i] = Math.max(dp2[i-1],dp1[i-1]-prices[i]);
        }
        return Math.max(dp1[prices.length-1],dp2[prices.length-1]);
    }
}
