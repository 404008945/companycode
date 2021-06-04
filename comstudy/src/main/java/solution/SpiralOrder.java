package solution;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {


    //可以递归
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();

        oneSpiralOrder(matrix,0,0,matrix.length-1,matrix[0].length-1,ans);

        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }

    public void oneSpiralOrder(int[][] matrix, int startX, int startY, int endX, int endY, List<Integer> ans){
        if (startX > endX || startY > endY) {
            return;
        }
        for(int j=startY;j<=endY;j++){
            ans.add(matrix[startX][j]);
        }
        for (int i = startX + 1; i <= endX; i++) {
            ans.add(matrix[i][endY]);
        }
        if(startX != endX && startY!=endY) {
            for (int j = endY - 1; j >= startY; j--) {
                ans.add(matrix[endX][j]);
            }
            for (int i = endX - 1; i > startX; i--) {
                ans.add(matrix[i][startY]);
            }
        }
        oneSpiralOrder(matrix,startX+1,startY+1,endX-1,endY-1,ans);
    }   

    //6 7

    //1  2  3  4
    //5  6  7  8
    //9 10 11 12


    //7
    //6
    //9
    public static void main(String[] args) {

    }
}
