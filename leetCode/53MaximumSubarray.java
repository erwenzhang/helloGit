public class Solution {
    public int maxSubArray(int[] nums){
    	int max = nums[0];
    	if(nums==null||nums.length==0) return 0;
    	int sum = 0;
    	for(int i = 0;i<nums.length;i++){
            sum +=nums[i];
            max = Math.max(max,sum);
            if(sum<0) sum = 0;
        }
        return max;
    }
    
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int maxSoFar = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){       
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;            
    }
}
