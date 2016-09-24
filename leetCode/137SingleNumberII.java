public class Solution{
    public int singleNumber(int[] nums){
        int[] count = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
               if(((nums[j] >> i)&1)==1) count[i]++;  
            }
            result |= ((count[i]%3) << i);
        } 
        return result;
    }
}

public class Solution{
    public int singleNumber(int[] nums){
        int ones = 0, twos = 0, threes = 0;
        for(int i = 0; i < nums.length; i++){
            twos |= ones&nums[i];
            ones ^= nums[i];
            threes = ones&twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones; // element appearing 1, 4, 7, etc times
    }
}



public class Solution {
    public int singleNumber(int[] A, int k, int l) {
        if (A == null) return 0;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for (int i = 0; i < A.length; i++) {
            t = x[k-1];
            for (int j = k-1; j > 0; j--) {
                x[j] = (x[j-1] & A[i]) | (x[j] & ~A[i]);
            }
            x[0] = (t & A[i]) | (x[0] & ~A[i]);
        }
        return x[l];
    }
}
