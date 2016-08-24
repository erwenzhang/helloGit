    public void solve(char[][] board){
        if(board == null) return;
        if(board.length == 0) return;
        for(int i = 0;i<board.length;i++){
            if(board[i][0]=='O'){
                bfs(board,i,0);
                board[i][0] = 'B';
            }
            if(board[i][board[0].length-1]=='O'){
                bfs(board,i,board[0].length-1);
                board[i][board[0].length-1] = 'B';
            }
        }
        for(int j = 0; j<board[0].length;j++){
            if(board[0][j]=='O'){
                bfs(board,0,j);
                board[0][j] = 'B';
            }
            if(board[board.length-1][j]=='O'){
                bfs(board,board.length-1,j);
                board[board.length-1][j] = 'B';
            }
        }
        for(int i = 0;i<board.length;i++){
            for(int j = 0; j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                if(board[i][j]=='B'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(char[][] board,int row,int col){
        int[][] diff = {{1,0,-1,0},{0,1,0,-1}};
        LinkedList<int[]> regions = new LinkedList<>();
        regions.add(new int[]{row,col});
        while(!regions.isEmpty()){
            int[] region = regions.remove();
            row = region[0];
            col = region[1];
            for(int i = 0;i<diff[0].length;i++){
                int newR = row + diff[0][i];
                int newC = col + diff[1][i];
                if(newR<0||newR>=board.length||newC<0||newC>=board[0].length||board[newR][newC]!='O')
                    continue;
                regions.add(new int[]{newR,newC});
                board[newR][newC] = 'B';
            }
        }
    }
