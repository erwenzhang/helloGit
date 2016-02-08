/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
    	if(node == null) return null;
        Map<Integer,UndirectedGraphNode> visited = new HashMap<>();
        return helper(node,visited);
    }
    
    public UndirectedGraphNode helper(UndirectedGraphNode node,Map<Integer,UndirectedGraphNode> visited){
        if(visited.containsKey(node.label)) return visited.get(node.label);
	UndirectedGraphNode tmp = new UndirectedGraphNode(node.label);
	visited.put(node.label,tmp);
        for(UndirectedGraphNode neighbor:node.neighbors){
	        tmp.neighbors.add(helper(neighbor,visited));
        }
        return tmp;
    }


}
