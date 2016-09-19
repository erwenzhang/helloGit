public class Solution {
     public String longestPalindrome(String s){
        int start = 0;
        int len = 0;
        String palindrome = "";
        for(int i = 0; i < s.length()*2 - 1; i++){
            String tmp = findPalindrome(s,i);
            if(tmp.length()>palindrome.length()) palindrome = tmp;
        }
        return palindrome;
    }

    public String findPalindrome(String s, int mid){
        int start = mid/2, end = start;
        if(mid%2!=0){
            end  = start + 1;
        }
        while(start>=0&&end<s.length()&&s.charAt(start)==s.charAt(end)){
            start--; end++;
        }
        return s.substring(start+1,end);
    }
}
