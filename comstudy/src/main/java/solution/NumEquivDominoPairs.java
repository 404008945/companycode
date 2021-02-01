package solution;

import java.util.*;
import java.util.stream.Collectors;

public class NumEquivDominoPairs {
    public static int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        int[] cp = new int[100];
        for(int[] arr:dominoes){
            Arrays.sort(arr);
            ans+=cp[arr[0]*10+arr[1]]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr [][] ={{1,1},{2,2},{1,1},{1,2},{1,2},{1,1}};
        System.out.println(numEquivDominoPairs(arr));
    }
}
