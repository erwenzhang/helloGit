public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict){
        if(wordDict.contains(s)) return true;
        boolean[] flag = new boolean[s.length()];
        for(int i = 1; i < s.length(); i++){
            String str = s.substring(0,i);
            if(wordDict.contains(str)||flag[i-1]){
                flag[i-1] = true;
                for(int j = i+1 ; j <= s.length(); j++){
                    if(wordDict.contains(s.substring(i,j))){
                        flag[j-1] = true;
                    }
                }
            }
        }
        return flag[s.length()-1];
    }
}
