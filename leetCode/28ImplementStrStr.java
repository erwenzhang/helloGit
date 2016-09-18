public class Solution {
    public int strStr(String hayStack, String needle){
        for(int i = 0;;i++){
            for(int j = 0;;j++){
                if(j==needle.length()) return i;
                if(j+i >= hayStack.length()) return -1;
                if(hayStack.charAt(i+j)!=needle.charAt(j)) break;
            }
        }
    }
}
