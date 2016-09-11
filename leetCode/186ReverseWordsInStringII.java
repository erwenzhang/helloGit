public class Solution {
    public void reverseWords(char[] s) {
        reverse(0,s.length-1,s);
        int start = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i]!=' ') continue;
            reverse(start, i-1, s);
            start = i + 1;
        }
        reverse(start,s.length-1,s);
    }

    public void reverse(int start, int end, char[] s){
        while(start<end){
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            end--;
            start++;
        }
    }
}
