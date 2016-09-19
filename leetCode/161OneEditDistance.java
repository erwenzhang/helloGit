public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m > n) return isOneEditDistance(t, s);
        if(n - m > 1) return false;
        int i = 0;
        int j = 0;
        int diff = 0;
        boolean sameLen = m==n?true:false;
        while(i<m&&j<n){
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++; 
                continue; 
            }
            diff++;
            if(diff > 1) return false;
            j++;
            if(sameLen){
                i++;
            }
        }
        return i==m&&j==n&&diff==1||j==n-1&&diff==0;
    }
}
