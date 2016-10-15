public class Solution {
    
    public int numberOfPatterns(int m, int n) {
           int[][] skip = new int[10][10];
           skip[1][3] = skip[3][1] = 2;
           skip[1][7] = skip[7][1] = 4;
           skip[3][9] = skip[9][3] = 6;
           skip[7][9] = skip[9][7] = 8;
           skip[1][9] = skip[9][1] = skip[3][7] = skip[7][3] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
           int res = 0;
           boolean[] visited = new boolean[10];
           for(int i=m; i<=n; i++){
               res += dfs(1, skip, i-1, visited)*4;
               res += dfs(2, skip, i-1, visited)*4;
               res += dfs(5, skip, i-1, visited);
           }
           return res;
    }
    
    public int dfs(int index, int[][] skip, int remaining, boolean[] visited){
        if(remaining==0) return 1;
        visited[index] = true;
        
        int result = 0;
        for(int i=1; i<=9; i++){
            if(!visited[i] && (skip[index][i]==0 || visited[skip[index][i]])){
                result+=dfs(i, skip, remaining-1, visited);
            }
        }
        visited[index] = false;
        return result;
    }
}
