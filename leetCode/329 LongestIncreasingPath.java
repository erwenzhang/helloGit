public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0) return 0;
        int row = matrix.length;
        int col = matrix[0].length; 
        int[][] len = new int[row][col];
        int longest = 0;
        for(int i = 0;i<row;i++){
        	for(int j = 0;j<col;j++){
        		dfs(i,j,matrix,len,Integer.MIN_VALUE);
        		longest = Math.max(longest,len[i][j]);
          }
        }
        return longest;
    }
    public int dfs(int x,int y,int[][] matrix,int[][] len,int pre){
        int longest = 0;
        if(x<0||x>=matrix.length||y<0||y>=matrix[0].length||matrix[x][y]<=pre) return 0;
        if(len[x][y]!= 0) return len[x][y];
        int cur = matrix[x][y];
    	  longest = Math.max(dfs(x-1,y,matrix,len,cur),longest);
        longest = Math.max(dfs(x+1,y,matrix,len,cur),longest);
        longest = Math.max(dfs(x,y+1,matrix,len,cur),longest);
        longest = Math.max(dfs(x,y-1,matrix,len,cur),longest);
        len[x][y] = longest+1;
        return longest+1;
    }
}
