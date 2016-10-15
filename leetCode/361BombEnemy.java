public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        
           if(grid==null || grid.length==0 || grid[0].length==0) return 0;
           int rows = 0;
           int[] cols = new int[grid[0].length];
           int max = 0;
           
           for(int i=0; i<grid.length; i++){
               for(int j=0; j<grid[0].length; j++){
                   
                   if(j==0 || grid[i][j-1]=='W'){
                       rows = killEnemiesRow(i, j, grid);
                   }
                   
                   if(i==0 || grid[i-1][j]=='W'){
                       cols[j] = killEnemiesCol(i, j, grid);
                   }
                   
                   if(grid[i][j]=='0'){
                       max = Math.max(rows+cols[j], max);
                   }
               }
           }
           
           return max;
    }
    
    public int killEnemiesRow(int i, int j, char[][] grid){
          int res = 0;
          while(j<grid[0].length && grid[i][j]!='W'){
              if(grid[i][j]=='E') res++;
              j++;
          }
          return res;
    }
    
    public int killEnemiesCol(int i, int j, char[][] grid){
          int res = 0;
          while(i<grid.length && grid[i][j]!='W'){
              if(grid[i][j]=='E') res++;
              i++;
          }
          return res;
    }
}
