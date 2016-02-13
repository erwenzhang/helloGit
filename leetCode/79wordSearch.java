public class Solution {
    public boolean exist(char[][] board,String word){
    	for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(search( i, j, board,word,0)) return true;
            }
        }
        return false;

    }

    public boolean search(int x,int y,char[][] board,String word,int index){
    	if(word.length()==index) return true;
    	if(x<0||x==board.length||y<0||y==board[0].length) return false;
    	if(board[x][y]==word.charAt(index)&&board[x][y]!='#'){
    		board[x][y]='#';
    		if(search(x+1,y,board,word,index+1)||search(x,y+1,board,word,index+1)||search(x-1,y,board,word,index+1)||search(x,y-1,board,word,index+1))
    			return true;
    	    board[x][y] = word.charAt(index);
    	}
        return false;
    
    }

}
