public class Solution {
    public boolean isMatch(String s,String p) {
        int len1 = s.length();
        int len2 = p.length();
        if(len1==0){
           return checkEmpty(p);
        }
        if(len2 == 0){
            return false;
        }

        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do
 
        if (p.length()>1){
            d2 = p.charAt(1);
        }
        
        if(d2=='*'){
            if(compare(c1,d1)){
            
            //fork here: 1. consume the character, and use the same pattern again.
                       //2. keep the character, and skip 'd1*' pattern
                       
                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1),p)||isMatch(s,p.substring(2));
            }else{
                return isMatch(s,p.substring(2));
            }
        }else{
            if(compare(c1,d1)){
                return isMatch(s.substring(1),p.substring(1));
            }else{
                return false;
            }
        } 
    }
    public boolean compare(char c, char d){
        return c==d||d=='.';
    }
    public boolean checkEmpty(String p){
        int len = p.length();
        if(len%2!=0) return false;
        for(int i = 1; i < len; i+=2){
            if(p.charAt(i)!='*') return false;
        }
        return true;
    }
  }
