public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        int start = 0, len = s.length();
        int numDistinct = 0;
        int maxLen = 0;
        int[] count = new int[256];
        for(int k = 0; k < len; k++){
            if(count[s.charAt(k)]==0) numDistinct++;
            count[s.charAt(k)]++;
            while(numDistinct>2){
                count[s.charAt(start)]--;
                if(count[s.charAt(start)]==0) numDistinct--;
                    start++;
            }
            maxLen = Math.max(maxLen, k - start + 1);
        }
        return maxLen;
    }
}
