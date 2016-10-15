public class Solution {
    boolean odd = false;
    List<String> ret;
    char[] medianSet={'0','1','8'};
    char[] startSet={'1','8','6','9'};
    char[] normalSet={'1','8','6','9','0'};
    public List<String> findStrobogrammatic(int n){
    	ret = new ArrayList<>();
    	if((n&1)==1) odd= true;
    	collectStrobogrammatic(n/2,"");	
    	return ret;
    }
    public void collectStrobogrammatic(int n,String str){
    	if(n==0){
            if(str.equals("")&&odd!=true) return;
            else{
            	StringBuilder sb = new StringBuilder(str);
            	sb.reverse();
            	transform(sb);
            	if(odd){
                	for(char median:medianSet){
                		sb.append(median).append(str);
                		ret.add(sb.toString());
                		sb.delete(sb.length()-str.length()-1,sb.length());
                    }
                }else{
            	    ret.add(sb.append(str).toString());
                }
            }
    	}else if(n==1){
    		for(char start:startSet){
    			collectStrobogrammatic(n-1,str+start);
            }
    
        }else{
        	for(char normal:normalSet){
        		collectStrobogrammatic(n-1,str+normal);
            }
        }
    
    }
    public void transform(StringBuilder sb){
    	for(int i =0;i<sb.length();i++){
    		if(sb.charAt(i)=='6')
    			sb.setCharAt(i,'9');
    		else if(sb.charAt(i)=='9'){
                sb.setCharAt(i,'6');
            }
        }
    }

}

//better sol
public class Solution {
    
    char[][] dict = {{'0','0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
   
    public List<String> findStrobogrammatic(int n) {
       if(n<=0) return new ArrayList<String>();
       List<String> result = new ArrayList<String>();
       char[] str = new char[n];
       helper(result, str, n, n, 0);
       return result;
    }
    
    public void helper(List<String> result, char[] str, int len, int length, int start){
        if(len<=0){
            result.add(new String(str));
            return;
        }
        
        for(int i=0; i<dict.length; i++){
            if(start==0 && len>1 && i==0) continue;
            if(len==1 && (i==2 || i==4)) continue;
            str[start] = dict[i][0];
            str[length-1-start] = dict[i][1];
            helper(result, str, len-2, length, start+1);
        }
    }
}
