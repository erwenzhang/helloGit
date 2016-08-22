public class Solution {
    public int countComponents(int n, int[][] edges){
        Set<Integer> visited = new HashSet<Integer>();    
        Graph gra = new Graph(edges,n);
        int components = 0;
        for(int i = 0;i<n;i++){
            if(visited.add(i)){
                dfs(gra,i,visited);
                components++;
            }     
        }
         return components;
     }

    public void dfs(Graph graph,int i,boolean[] visitNodes){
        Set<Integer> vertexSet = graph.get(i);
        if(vertexSet == null) return;
        for(Integer vertex: vertexSet){
            if(visiteNodes.add(vertex)){
                dfs(graph,vertex,visitNodes);
            }
        }
    }

    public static class Graph{
        Map<Integer,Set<Integer>>[] edges = new HashMap<Integer,Set<Integer>>();
        Graph(int[][] edges, int n){
            for(int i = 0;i<n;i++){
                edges.put(i,new HashSet<Integer>());
            }  
            for(int[] edge:edges){
                graph.get(edge[0]).add(edge[0]);
                graph.get(edge[1]).add(edge[1]);
            } 
         } 
    }
}
