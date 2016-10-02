public class Solution {
    public int numIslands(char[][] grid ){

        int len1= grid.length;
        int count = 0;
        if(len1==0){
            return 0;
        }
        int[][] moves = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int len2= grid[0].length;
        boolean[][] flag=new boolean[len1][len2];
        Queue<Integer> que = new Queue<Integer>();
        for(int i =0;i<len1;i++){
            for(int j=0;j<len2;j++){
                if(grid[i][j]=='1'){
                    count++;
                    que.add(i*len2+j);
                    grid[i][j] = '0';
                    while(!que.isEmpty()){
                        int num = que.poll();
                        for(int[] move:moves){
                            int nextRow = num/len2 + move[0];
                            int nextCol = num%len2 + move[1];
                            if(nextRow<0||nextRow>=len1||nextCol<0||nextCol>=len2||grid[nextRow][nextCol]!='1') continue;
                            que.add(nextRow*len2+nextCol);
                            grid[nextRow][nextCol] = '0';
                        }
                    }
                }    
            }
        }
        return count;
    }
}
