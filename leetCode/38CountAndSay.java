public class Solution {
   public String countAndSay(int n){
    	String oldString = "1";
    
    	for(int j = 1;j<n;j++){
    		    StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();
        		for(int i = 0;i<oldChars.length;i++){
        			int count = 1;
        			while((i+1)<oldChars.length&&oldChars[i]==oldChars[i+1]){
                        count++;
                        i++;
        			}
              sb.append(count).append(oldChars[i]);
            }
              oldString = sb.toString();
    }
        return oldString;
    }
  }
