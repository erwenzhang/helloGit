public class Solution {
    public int shortestDistance(int[][] grid) {
        
           if(grid==null || grid.length==0 || grid[0].length==0) return 0;
           int[][] directions = {{-1,0}, {1,0}, {0,1}, {0,-1}};
           
           int rows = grid.length;
           int cols = grid[0].length;
           int[][] distance = new int[rows][cols];
           int[][] reach = new int[rows][cols];
           int buildings = 0;
           
           for(int i=0; i<rows; i++){
               for(int j=0; j<cols; j++){
                   if(grid[i][j]==1){
                       Queue<int[]> queue = new LinkedList<>();
                       queue.add(new int[]{i, j});
                       boolean[][] visited = new boolean[rows][cols];
                       int level = 1;
                       buildings++;
     
                       while(!queue.isEmpty()){                
                           int size = queue.size();
                           for(int k=0; k<size; k++){
                               int[] temp = queue.poll();
                               for(int[] direction : directions){
                                    int x = temp[0]+direction[0];
                                    int y = temp[1]+direction[1];                        
                                    if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y]==1 || grid[x][y]==2 || visited[x][y]) continue;                                    
                                    queue.add(new int[]{x, y});
                                    reach[x][y]++;
                                    distance[x][y]+=level;
                                    visited[x][y] = true;
                                }
                           }
                           level++;
                       }
                   }
               }
           }
           
           int res = Integer.MAX_VALUE;
           for(int i=0; i<rows; i++){
               for(int j=0; j<cols; j++){
                   if(grid[i][j]==0 && reach[i][j]==buildings){
                       res = Math.min(res, distance[i][j]);
                   }
               }
           }
           
           return res==Integer.MAX_VALUE? -1 : res;
    }
}
