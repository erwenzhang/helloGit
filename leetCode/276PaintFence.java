public class Solution {
    public int numWays(int n, int k){
        if(n == 0) return 0;
        if(n == 1) return k;
        int same = k;
        int diff = k*k - k;
        for(int i = 2; i< n ; i++){
            int numWays = same*(k-1) + diff*k;
            same = diff;
            diff = numWays - same;
        }
        return same+diff;
    }
}
