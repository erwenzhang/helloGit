/*Sol 1, o(n)*/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
      if(nums==null||nums.length==0) return 0;
      int len = Integer.MAX_VALUE;
      int p1 = 0;
      int p2 = 0;
      int sum = 0;
      while(p2<nums.length){
          sum+=nums[p2++];
          while(sum>=s){
              len = Math.min(len, p2 - p1);
              sum -= nums[p1++];
          }
      }
      return len==Integer.MAX_VALUE?0:len;
    }
}

/*Sol 2, o(nlogn)*/
    /* Min Size Subarray Sum Equals k, o(nlogn)*/
    public int minSubArrayLen1(int s,int[] nums){
        if(nums==null||nums.length==0) return 0;
        int[] sum = new int[nums.length+1];
        sum[0] = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 1; i <= nums.length;i++){sum[i]+= sum[i-1]+nums[i-1];}
        for(int i = 0; i < sum.length-1; i++){
            int end = binarySearch(i+1, sum.length-1,sum[i]+s,sum);
            if(end==sum.length) break;
            len = Math.min(len,end-i);
        }
        return len==Integer.MAX_VALUE?0:len;
    }
