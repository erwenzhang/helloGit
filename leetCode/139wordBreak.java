public class Solution {
     public boolean wordBreak(String s, Set<String> wordDict){
        if(wordDict.contains(s)) return true;
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0;j<i;j++){
                if(flag[j]&&wordDict.contains(s.substring(j,i))){
                    flag[i] = true;
                    break;
                }
            }
        }
        return flag[s.length()];
   }
}
