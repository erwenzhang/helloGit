public class Solution {
      public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph){
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        if(graph==null) return null;
        queue.add(graph);
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
        map.put(graph, graphCopy);
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            for(UndirectedGraphNode neighbor: node.neighbors){
                UndirectedGraphNode copyNeighbor;
                if(map.containsKey(neighbor)) copyNeighbor= map.get(neighbor);
                else {
                    copyNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor,copyNeighbor);
                    queue.add(neighbor);
                }
                map.get(node).neighbors.add(copyNeighbor);
            }
        }
        return graphCopy;
    }
}
