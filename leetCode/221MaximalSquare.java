public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            if(matrix[i][0]=='1') dp[i][0] = 1;
        }
        for(int i = 0; i < col; i++){
            if(matrix[0][i]=='1') dp[0][i] = 1;
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }  
        int max = 0;
        for(int i=0; i<row; i++){
              for(int j=0; j<col; j++){
                  max = Math.max(max, dp[i][j]);
              }
          }
        return max*max;
    }
}
