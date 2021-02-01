package solution;

public class IntegerBreak {
  static    int max(int a,int b,int c){
        return Math.max(a,Math.max(b,c));
    }
    public static int integerBreak(int n) {
        if(n == 1||n==2){
            return 1;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for(int j=1;j<=i-1;j++){
                dp[i] = max(dp[i],j*(i-j),dp[j]*(i-j));
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }
}
