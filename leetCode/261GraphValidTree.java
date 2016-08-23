public class Solution {
  /** Solution 1, to check if there is a circle in the graph by checking the number of edges is 1 less than number of vertexes.*/
    public boolean validTree(int n, int[][] edges){
        int numOfEdges = edges.length;
        if(numOfEdges!= n-1) {
            return false;
        }
        int[] roots = new int[n];
        for(int i = 0;i<n; i++){
            roots[i] = i;
        }
        
        int components = n;
        for(int[] edge:edges){
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if(root1!=root2){
                components--;
                roots[root1] = root2;
            }
        }
        return components==1;
    }
    
    public int findRoot(int[] roots, int node){
      while(roots[node]!=node){
        roots[node] = roots[roots[node]]; // compress the path
        node = roots[node];
      }
      return node;
  }
  
  /** Solution 2, to check if there is a circle in the graph by checking the root of two nodes of an edge*/
  public boolean validTree(int n,int[][] edges){
     int components = n;
     int[] roots = new int[n];
     for(int i = 0;i<n;i++) roots[i] = i;
     for(int[] edge:edges){
          int node1 = edge[0];
          int node2 = edge[1];
          int root1 = findRoot(node1,roots);
          int root2 = findRoot(node2,roots);
          if(root1==root2) return false; // node1,node2 are already connected, so a circle
          else roots[root1] = root2;
          components--;
     }
     return components==1;
  }

  public int findRoot(int node,int[] roots){
     while(node!=roots[node]){
          node = roots[node];
     }
     return node;
  }
}
