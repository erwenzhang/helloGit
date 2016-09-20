public class Solution {
    private static final int maxDivBy10 = Integer.MAX_VALUE/10;
    public int reverse(int x){
        int reversed = 0;
        while(x!=0){
            int digit = x%10;
            int checkOverflow = Math.abs(reversed);
            if(checkOverflow > maxDivBy10 || checkOverflow == maxDivBy10&&digit>=8) return 0;
            reversed = reversed*10 + digit;
            x /= 10;
        }
        return reversed;
    }
}
