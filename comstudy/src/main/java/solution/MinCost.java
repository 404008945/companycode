package solution;

import java.util.Scanner;

public class MinCost {

    public static int minCost(String s, int[] cost) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int  tsum= 0;
        for(int i=0;i<s.length();i++){
            tsum += cost[i];
            if(i<s.length()-1&&s.charAt(i) == s.charAt(i+1)){
                max = Math.max(max,cost[i]);
                max = Math.max(max,cost[i+1]);
            }else {
                if (max != Integer.MIN_VALUE) {
                    sum += tsum - max;
                    max = Integer.MIN_VALUE;

                }
                tsum = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){

        }
        String str = "abaac";
        int []cost = {1,2,3,4,5};

        System.out.println(minCost(str,cost));
    }
}
