public class Solution {
   public int threeSumSmaller(int[] nums, int target) {
           if(nums==null || nums.length==0) return 0;
           Arrays.sort(nums);
           int count = 0;
           for(int i=0; i<nums.length-2; i++){
               int start = i+1;
               int end = nums.length-1;
               while(start<end){
                   if(nums[i]+nums[start]+nums[end]<target){
                       count+=end-start;
                       start++;
                   }else{
                       end--;
                   }
               }
           }
           return count;
    }
}
