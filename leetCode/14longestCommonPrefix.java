public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null||strs.length==0) return "";
        String first = strs[0];

        int j = 0;
        for(;j<first.length();j++){
        	int i = 1;
        	for(;i<strs.length;i++){
            	if(strs[i].length()-1<j||first.charAt(j)!=strs[i].charAt(j)){
            		break;
                }
            } 
            if(i<strs.length) break;
        }
        return first.substring(0,j);
       
    }

}s
