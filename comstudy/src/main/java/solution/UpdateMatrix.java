package solution;

public class UpdateMatrix {

    int dx[] = {1, -1, 0, 0};
    int dy[] = {0, 0, 1, -1};

    public int dfs(int [][]matrix,int x,int y,int len,boolean vis[][]){
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if(vis[x][y]){
            return Integer.MAX_VALUE;
        }
        if(matrix[x][y] == 0){
            return len;
        }
        vis[x][y] = true;
        //四个方向遍历,判断是否访问过
        int val = Integer.MAX_VALUE;;
        for (int di = 0; di < 4; di++) {
            int tx = x+dx[di];
            int ty = y+dy[di];

            val = Math.min(val,dfs(matrix,tx,ty,len+1,vis));
        }
        vis[x][y] = false;
        return val;
    }

    public int[][] updateMatrix(int[][] matrix) {
        //dfs深搜
        int [][] map = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                map[i][j] = dfs(matrix,i,j,0,new boolean[matrix.length][matrix[0].length]);
            }
        }
        return map;
    }
//     0 0 0
//     0 1 0
//     1 1 1
}
