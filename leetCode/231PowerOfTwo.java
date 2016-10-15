public class Solution {
    public boolean isPowerOfTwo(int n) {
        return (Math.log10(n) / Math.log10(2)) % 1 == 0;
    }
    
    //this one is very clever!!!
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        return !(n&(n-1));
    }
}
