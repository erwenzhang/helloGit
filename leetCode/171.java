public class Solution {
    public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        for(char cur:array){
            result = result*26+cur-'A'+1;
        }
        return result;
    }
}
