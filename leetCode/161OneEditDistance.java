public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>1) return false; 
        int len1 = s.length();
        int len2 = t.length();
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while(p1<len1&&p2<len2){
        	if(s.charAt(p1)!=t.charAt(p2)){
	            count++;
	            if(count>1) return false;
              if((p1+1<len1)&&s.charAt(p1+1)==t.charAt(p2)){
                    p1++;
              }else if((p2+1<len2)&&t.charAt(p2+1)==s.charAt(p1)){
                	p2++;
              }
          }
          p1++;
          p2++;
        } 
        if(p1<len1||p2<len2) return count==0;
        else return count!=0;
    }
}
