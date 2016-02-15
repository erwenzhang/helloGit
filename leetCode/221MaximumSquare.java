public class Solution {
    public int maximalSquare(char[][] matrix) {
        int square = 0;
        for(int i = 0;i<matrix.length;i++){
	        for(int j = 0;j<matrix[0].length;j++){
	            if(matrix[i][j]=='1'){
	                if(i>0&&j>0){
	                  matrix[i][j] = (char)(Math.min(Math.min(matrix[i-1][j-1]-'0',matrix[i-1][j]-'0'),matrix[i][j-1]-'0')+1+'0');
	                }
	                square = Math.max(matrix[i][j]-'0',square);
                }
            }
        }  
        return square*square;      
    }
}
