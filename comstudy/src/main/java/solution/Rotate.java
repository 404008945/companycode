package solution;

import java.util.Arrays;

public class Rotate {
    //如果允许再创建一个矩阵，怎么处理
    public static void rotate(int[][] matrix) {
        //第一步，按照旋转顺序循环
       int arr[][] = new  int[matrix.length][matrix.length];
       int r= 0;
       int c= 0;
            for (int j = 0; j < matrix.length;j++) {
                for (int i = matrix.length - 1; i >= 0; i--) {
                //列替换到行上
                if(r>=matrix.length){
                    break;
                }
                arr[r][c] = matrix[i][j];
                c++;
                if(c == matrix.length){
                    r++;
                    c=0;
                }
            }

        }
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix.length;j++){
               matrix[i][j] = arr[i][j];
           }
       }
    }

    public static void main(String[] args) {
        int arr[][] = new  int[][]{
                {1,2,3},
                {4,5,6},
  {7,8,9}
        };
        rotate(arr);
    }
}
