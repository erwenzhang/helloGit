public class Solution {
      public int countComponents(int n, int[][] edges){
        boolean[] visitNodes = new boolean[n];
        if(n==0||edges==null){
            return 0;
        }
        Graph gra = new Graph(edges);
        int numOfComponents = 0;
        for(int i = 0 ;i < n;i++){
            if(visitNodes[i]){
                continue;
            }
            traverse(gra,i,visitNodes);
            numOfComponents++;
        }
        return numOfComponents;
    }
    public void traverse(Graph graph,int i,boolean[] visitNodes){
        visitNodes[i] = true;
        Set<Integer> vertexSet = graph.edges.get(i);
        if(vertexSet == null) return;
        for(Integer vertex: vertexSet){
            if(visitNodes[vertex]){ 
                continue;
            }
            traverse(graph,vertex,visitNodes);
        }
    }
    public static class Graph{
        Map<Integer,Set<Integer>> edges = new HashMap<Integer,Set<Integer>>();
        Graph(int[][] edges){
            for(int[] edge:edges){
                Set<Integer> vertexSet0 = this.edges.get(edge[0]);
                Set<Integer> vertexSet1 = this.edges.get(edge[1]);
                if(vertexSet0 == null){
                    this.edges.put(edge[0], new HashSet<Integer>());
                }
                if(vertexSet1 == null){
                    this.edges.put(edge[1], new HashSet<Integer>());
                }
                this.edges.get(edge[0]).add(edge[1]);
                this.edges.get(edge[1]).add(edge[0]);
            }
        }
    }
}
