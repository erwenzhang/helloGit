public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n>10) n = 10;
        int[] f = new int[11];
        int[] g = new int[11];
        g[1] = 9;
        f[1] = 1;
        int sum = g[1]+f[1];
        for(int i = 2; i <= n; i++){
            f[i] = f[i-1]*(10-(i-1)) + g[i-2]*(10-(i-1));
            g[i] = g[i-1]*(9-(i-1));
            sum = sum + f[i] + g[i];
        }  
        return sum;     
    }
}



//Simpler
public class Solution {
    public int countNumbersWithUniqueDigits(int n){
       if(n==0) return 1;
       if(n>10) n = 10;
       int res = 10;
       int availableNums = 9;
       int uniqueDigits = 9;
       for(int i = 2; i <= n; i++){
           uniqueDigits = availableNums*uniqueDigits;
           res += uniqueDigits;
           availableNums--;  
       }
       return res;
    }
}
