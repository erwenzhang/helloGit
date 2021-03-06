public class Solution {
   public List<String> findItinerary(String[][] tickets){
      List<String> route = new LinkedList<>();
    	if(tickets == null||tickets.length == 0) return route;
    	Map<String,Queue<String>> graph = new HashMap<>();
    	for(String[] ticket:tickets){
    		if(graph.get(ticket[0])==null)
    			graph.put(ticket[0],new PriorityQueue<String>());
    		graph.get(ticket[0]).add(ticket[1]);
    	    
    	}
      dfs(graph,route,"JFK");
      return route;

   }
       
    public void dfs(Map<String,Queue<String>> graph,List<String> route,String visited){
        while(graph.containsKey(visited)&&!graph.get(visited).isEmpty()){ 
            dfs(graph,route,graph.get(visited).poll());
        }
        route.add(0,visited);
    }

}
