package solution;

import java.util.LinkedList;

public class UpdateMatrix2 {
    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};
    public int[][] updateMatrix(int[][] matrix) {//队列办法
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i=0;i<matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    //加入队列
                    queue.offer(new int[]{i,j});
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()){
            int temp[] =queue.poll();
            //影响四个方向
            for(int di =0;di<4;di++){
                int x = temp[0]+dx[di];
                int y = temp[1]+dy[di];
                if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
                    continue;
                }
                if(matrix[x][y] <= matrix[temp[0]][temp[1]]){
                    continue;
                }else {
                    matrix[x][y] = Math.min(matrix[x][y],matrix[temp[0]][temp[1]]+1);
                    queue.push(new int[]{x,y});
                }
            }
        }
        return matrix;
    }
}
