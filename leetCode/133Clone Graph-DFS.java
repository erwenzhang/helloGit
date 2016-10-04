/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        map.put(node, head);
        helper(map, node);
        return head;
    }
    
    private void helper(Map<UndirectedGraphNode, UndirectedGraphNode> map, UndirectedGraphNode node){
        List<UndirectedGraphNode> neighbors = node.neighbors;
        for(UndirectedGraphNode neighbor : neighbors){
            if(!map.containsKey(neighbor)){
                UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor, copy);
                helper(map, neighbor);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

}
