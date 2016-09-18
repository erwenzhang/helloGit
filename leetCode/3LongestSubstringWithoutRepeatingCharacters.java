public class Solution {
    public int lengthOfLongestSubstring(String s){
        int[] charMap = new int[256];
        Arrays.fill(charMap,-1);
        int start = 0;
        int len = 0;
        for(int k = 0; k < s.length(); k++){
            start = Math.max(start, charMap[s.charAt(k)]+1);
            charMap[s.charAt(k)] = k;
            len = Math.max(len, k - start+1);
        }
        return len;
    }
}
