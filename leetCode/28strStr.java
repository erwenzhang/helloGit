public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        for(int i = 0;i< len1 - len2+1;i++){
            boolean flag = true;
        	for(int j = 0;j<len2;j++){
        		if(haystack.charAt(i+j)!=needle.charAt(j)){
        	        flag = false;
        	        break;
                }
            }
            if(flag) return i;
        }
        return -1;       
    }

}
