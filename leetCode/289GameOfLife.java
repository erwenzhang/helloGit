public class Solution {
    public void gameOfLife(int[][] board){
	    if(board==null) return;
	    int rows = board.length, columns = board[0].length;
	    for(int i = 0;i<rows;i++){
		    for(int j = 0;j<columns;j++){
	            int neighbors = countNeighbors(board,i,j,rows,columns);
	            if( neighbors>=2&&neighbors<=3&&board[i][j]==1){
		            board[i][j] = 3;
                    }else if(neighbors==3&&board[i][j]==0){
		            board[i][j]= 2;
                    }
            }
        }
        for(int i = 0;i<rows;i++){
        	for(int j = 0; j<columns;j++){
        	    board[i][j]=(board[i][j]>>1);
                }
        }
    }
    public int countNeighbors(int[][] board,int i,int j,int rows,int columns){
    	int count = 0;
    	for(int x = Math.max(i-1,0);x<=Math.min(i+1,rows-1);x++){
    		for(int y = Math.max(j-1,0);y<=Math.min(j+1,columns-1);y++){
    			count+=(board[x][y]&1);
            }
        }
        count = count - (board[i][j]&1);
        return count;	
    }
}
