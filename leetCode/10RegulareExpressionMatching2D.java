public class Solution{
    public boolean isMatch(String str1, String str2){
        int len1=str1.length();
        int len2 = str2.length();

        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;

        for(int i = 1;i<len2+1;i++){
            if(str2.charAt(i-1)=='*'){
                if(i==1){
                    dp[0][i]=dp[0][i-1];  continue;
                }
                dp[0][i]=dp[0][i-2]||dp[0][i-1];    
            }
        }

        for(int i =1 ;i<len1+1;i++){
            for (int j = 1;j<len2+1;j++){
                if(str2.charAt(j-1)=='.'||str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(str2.charAt(j-1)=='*'){
                    if(j==1){
                        dp[i][j]=dp[i][j-1]; continue;
                    }
                    dp[i][j]=dp[i][j-1]||dp[i][j-2]||(dp[i-1][j]&&(str1.charAt(i-1)==str2.charAt(j-2)||str2.charAt(j-2)=='.'));                   
                }
                else
                    dp[i][j] = false;
            }
        }
        return dp[len1][len2];
    }    
}
