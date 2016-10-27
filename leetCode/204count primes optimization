public class Solution {
    public int countPrimes(int n) {
        if(n<3) return 0;
        boolean[] flag = new boolean[n];
        int count = 0;
        for(int i = 2; i*i <= n;i++){
            if(flag[i]) continue;
            for(int j = i; j*i < n;j++){
                if(!flag[j*i]){
                    flag[j*i] = true;
                    count++;
                }
            }
        }
        return n-2-count;
    }
}
