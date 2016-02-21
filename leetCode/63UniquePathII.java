public class Solution {
    
    public int uniquePathsWithObstacles(int[][] grid){
	int row = grid.length;
	
	if(row==0||grid[0][0]==1) return 0;
	int column = grid[0].length;
    	int[][] dp = new int[row][column];
    	dp[0][0] = 1;
	for(int i = 1;i<column;i++){
		if(grid[0][i]==0) dp[0][i] = dp[0][i-1];
		else break;
    	}
	for(int j = 1;j<row;j++){
		    if(grid[j][0]==0) dp[j][0] = dp[j-1][0];
			else break;
	}
        for(int i = 1;i<row;i++){
	    for(int j = 1;j<column;j++){
		    if(grid[i][j]==0) dp[i][j] = dp[i-1][j]+dp[i][j-1];
        }
        }
	return dp[row-1][column-1];
    }
    
    
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int columns = grid[0].length;
        int[] dp = new int[columns];
        dp[0] = 1;
        for(int[] rows:grid){
            for(int i = 0;i<columns;i++){
                if(rows[i]==1) dp[i] = 0;
                else if(i>0){
                    dp[i]+=dp[i-1];
                }
            }
            
        }
        return dp[columns-1];
        
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
            if(grid==null||grid.length==0) return 0;
            int columns = grid[0].length;
            int rows = grid.length;
            int[][] dp = new int[rows][columns];
            dp[0][0] = 1;
            for(int j = 0;j< rows;j++){
                for(int i = 0;i<columns;i++){
                    if(grid[j][i]==1) {dp[j][i] = 0;continue;}
                    if(i>0){
                        dp[j][i]+=dp[j][i-1];
                    }
                    if(j>0) dp[j][i]+=dp[j-1][i];
                }
            }
            return dp[rows-1][columns-1];
        
    }

}
