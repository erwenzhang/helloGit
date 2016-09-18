public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k){
        int start = 0, len = s.length();
        int numDistinct = 0;
        int maxLen = 0;
        int[] count = new int[256];
        for(int j = 0; j < len; j++){
            if(count[s.charAt(j)]==0) numDistinct++;
            count[s.charAt(j)]++;
            while(numDistinct>k){
                count[s.charAt(start)]--;
                if(count[s.charAt(start)]==0) numDistinct--;
                start++;
            }
            maxLen = Math.max(maxLen, j - start + 1);
        }
        return maxLen;
    }
}
