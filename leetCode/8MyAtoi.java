public class Solution {
    private static final int maxDivBy10 = Integer.MAX_VALUE/10; //214748364, the max integer value 2147283647,
    
    public int myAtoi(String str){
        int i = 0, n = str.length();
        while(i<n&& str.charAt(i)==' ') i++;
        int sign = 1;
        if(i<n&&str.charAt(i)=='+') {sign = 1;i++;}
        else if(i<n&&str.charAt(i)=='-') {sign = -1;i++;}
        int num = 0;
        while(i<n&&Character.isDigit(str.charAt(i))){
            int digit = str.charAt(i)-'0';
            if(num > maxDivBy10||num==maxDivBy10&&digit >= 8) { // very clever,
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            num = num*10 + digit;
            i++;
        }
        return num*sign;
    }
}
