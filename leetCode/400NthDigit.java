public class Solution {
    public int findNthDigit(int n) {
        long cnt = 9, start = 1; 
        int len = 1;
        while(n>cnt*len){
            n -= cnt*len;
            cnt*=10;
            len++;
            start*=10;
        }
        start += (n-1)/len;
        String s = Long.toString(start);
        return (int)(s.charAt((n-1)%len)-'0');
    }
}
