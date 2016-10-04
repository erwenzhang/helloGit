public class Solution {
    public int maxProduct(int[] nums){
    	if(nums == null||nums.length==0) return 0;
    	int max = nums[0];
    	int min = nums[0];
    	int p = 1;
    	int ret_max = max;
    	for(int i = 1;i<nums.length;i++){
        if(nums[i]>0){
            max = Math.max(nums[i]*max,nums[i]);
            min = Math.min(nums[i]*min,nums[i]);
        }
        else{
            int tmp = max;
            max = Math.max(nums[i]*min,nums[i]);
            min = Math.min(nums[i]*tmp,nums[i]);
        }	
        ret_max = Math.max(ret_max,max);
    
        }
    	return ret_max;	
    }
}
