public class Solution {
    public int climbStairs(int n){
        if(n == 0 || n == 1) return n;
        int pre = 2;
        int prepre = 1;
        for(int i = 2;i < n ; i++){
            int tmp = pre + prepre;
            prepre = pre;
            pre = tmp;
        }
        return pre;
  }
}
