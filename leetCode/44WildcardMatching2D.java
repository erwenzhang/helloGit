public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
    
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0]= true; 
        s = " "+s; p = " "+p;
        for(int i = 1; i <= len2; i++){
            if(p.charAt(i)!='*') break;
            dp[0][i] = true;;    
        }  
    
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(p.charAt(j)==s.charAt(i)||p.charAt(j)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j)=='*'){
                    dp[i][j] = dp[i-1][j]||dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        } 
        return dp[len1][len2];    
    }
}
