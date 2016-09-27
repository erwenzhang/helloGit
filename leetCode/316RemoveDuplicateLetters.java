public class Solution {
    public String removeDuplicateLetters(String s){
	    int[] counts = new int[26];
	    boolean[] visited = new boolean[26];
	    Stack stack = new Stack();
	    char[] array = s.toCharArray();
	    for(char cur:array){
		    counts[cur-'a']++;
            }
        
            for(char cur:array){
            	counts[cur-'a']--; // should put at first;
	  	if(visited[cur-'a']) continue;
          	while(!stack.isEmpty()&&(char)stack.peek()>cur&&counts[(char)stack.peek()-'a']>0){
 	        	visited[(char)stack.pop()-'a'] = false;
          	}
            	stack.push(cur);
            	visited[cur-'a'] = true;
            }
            String rets = "";
            while(!stack.isEmpty()){
            	rets = (char)stack.pop()+rets;
      	    }
	    return rets;
     }
}
