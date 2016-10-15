public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new LinkedList<>();
        if(m == 0) {
            return res;
        }
        int[][] grid = new int[m][n];
        int[] tree = new int[m*n];
        int[] weight = new int[m*n];
        int num = 0;
        for(int i=0; i< tree.length; i++) {
            tree[i] = i;
            weight[i] = 1;
        }
        for(int[] position: positions) {
            num ++;
            int i = position[0], j = position[1];
            grid[i][j] = 1;
            if(i > 0 && grid[i-1][j] == 1) {
                if(connect(tree, weight, index(i, j, n), index(i-1, j, n))) {
                    num --;
                }
            }
            if(i < m-1 && grid[i+1][j] == 1) {
                if(connect(tree, weight, index(i, j, n), index(i+1, j, n))) {
                    num --;
                }
            }
            if(j > 0 && grid[i][j-1] == 1) {
                if(connect(tree, weight, index(i, j, n), index(i, j-1, n))) {
                    num --;
                }
            }
            if(j < n-1 && grid[i][j+1] == 1) {
                if(connect(tree, weight, index(i, j, n), index(i, j+1, n))) {
                    num --;
                }
            }
            res.add(num);
        }
        return res;
    }
    
    private int root(int[] tree, int i) {
        if(tree[i] == i) {
            return i;
        } else {
            return tree[i] = root(tree, tree[i]);
        }
    }
    
    private boolean connect(int[] tree, int[] weight, int i, int j) {
        i = root(tree, i);
        j = root(tree, j);
        if(i == j) {
            return false;
        }
        if(weight[i] <= weight[j]) {
            tree[i] = j;
            weight[j] += weight[i];
        } else {
            tree[j] = i;
            weight[i] += weight[j];
        }
        return true;
    }
    
    private int index(int i, int j, int n){
        return i*n+j;
    }
}


// sol2
public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
           List<Integer> result = new ArrayList<>();
           int[] roots = new int[m*n];
           Arrays.fill(roots, -1);
           int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
           
           int count = 0;
      
           
           for(int[] position : positions){
               count++;
               int root = position[0]*n+position[1];
               roots[root] = root;
               
               for(int[] direction : directions){
                   int x = position[0]+direction[0];
                   int y = position[1]+direction[1];
                   int temp = x*n+y;
                   if(x<0 || x>=m || y<0 || y>=n || roots[temp]==-1) continue;
                   
                   int rootTmp = find(roots, temp);
                   if(rootTmp!=root){
                       count--;
                       roots[root] = rootTmp;
                       root = rootTmp;
                   }
                   
                   
               }
               result.add(count);
           }
           return result;
    }
    
    public int find(int[] nums, int x){
        while(nums[x]!=x) x = nums[x];
        return x;
    }
    
   
}
