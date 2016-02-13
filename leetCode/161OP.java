public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int p1 = 0;
        int p2 = 0;
        while(p1<len1&&p2<len2){
        	if(s.charAt(p1)!=t.charAt(p2)){
	            return s.substring(p1+1).equals(t.substring(p2))||t.substring(p2+1).equals(s.substring(p1))||t.substring(p2+1).equals(s.substring(p1+1));
            }
            p1++;
            p2++;
        } 
        return Math.abs(s.length()-t.length())==1; 
    }

}
