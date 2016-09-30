public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        int sIndex, pIndex = 0, sS = -1, pS = -1;
        for(sIndex = 0;sIndex<len1;){
            if(pIndex<len2&&(s.charAt(sIndex)==p.charAt(pIndex)||p.charAt(pIndex)=='?')){
                sIndex++;pIndex++; 
            }else if(pIndex<len2&&p.charAt(pIndex)=='*'){
                sS = sIndex; pS = pIndex; pIndex++; //sS and pS are used for backtracking
            }else if(pS!=-1){
                sS++; // previous one doesn't work
                sIndex = sS; pIndex = pS + 1;
            }else{ 
                return false;
            }
        }    
        while(pIndex<len2){
            if(p.charAt(pIndex++)!='*') return false;
        }
        return true;
    }
}
