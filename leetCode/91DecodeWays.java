public class Solution {
    public int numDecodings(String s){
    	int pre_pre = 1;
    	int pre = 1;
      if(s.length()==0||s.startsWith("0")) return 0;
        
    	for(int i = 2;i<=s.length();i++){
    	    int first = Integer.parseInt(s.substring(i-2,i));
    	    int second = Integer.parseInt(s.substring(i-1,i));
    	    int tmp_pre = (first<27&&first>9)?pre_pre:0; // can use the pre_pre,
    	    int plus = (second==0)?0:pre; //can use the pre
    	    pre_pre = pre; 
    	    pre = tmp_pre+plus; // cur value;
        }
        
        return pre;

    }

}
