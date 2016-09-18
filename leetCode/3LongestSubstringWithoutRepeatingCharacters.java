public class Solution {
    public int lengthOfLongestSubstring(String s){
        int[] charMap = new int[256];
        Arrays.fill(charMap,-1);
        int end = 0;
        int start = 0;
        int len = Integer.MIN_VALUE;
        while(end<s.length()){
            len = Math.max(len, end - start);
            start = Math.max(start, charMap[s.charAt(end)]+1);
            charMap[s.charAt(end)] = end;
            end++;
        }
        return Math.max(len,end-start);
    }
}
