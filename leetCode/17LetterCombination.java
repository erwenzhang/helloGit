public class Solution {
    public List<String> letterCombinations(String digits){
    	if(digits==null||digits.length()==0)
    		return new ArrayList<>();
    	else{
    	    List<String> rets = new ArrayList<>();
    	    StringBuilder sb = new StringBuilder();
    	    dfs(rets,sb,0,digits);
    	    return rets;
    	}
    }
    public void dfs(List<String> rets,StringBuilder sb,int index,String digits){
    	if(index==digits.length()){
    	        rets.add(sb.toString());
    	        return;
      }
    	int cur = digits.charAt(index)-'0';
    	if(cur==0||cur==1) return;
        int start;
        switch(cur){
            case 7:
                start = 'p';
                break;
            case 8:
                start = 't';
                break;
            case 9:
                start = 'w';
                break;
            default:
                start = (cur-2)*3+'a';
        }
    	int count=(cur==9||cur==7)?4:3;
    	int len = sb.length();
    	for(int i=0;i<count;i++){
    		sb.append((char)(start+i));
    		dfs(rets,sb,index+1,digits);
    		sb.setLength(len);
      }
    }

}
