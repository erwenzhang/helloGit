public class Solution {
    public void moveZeroes(int[] nums){
	    int count = 0;
	    for(int i = 0;i<nums.length;i++){
	        if(nums[i]!=0)
	            nums[count++]=nums[i];
	    }
	    for(int i = count;i<nums.length;i++){
	        nums[i] = 0;
	    }
    }
    
}


public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null) return;
        int zeroIndex = 0;
        int nonZeroIndex = 0;
        while(zeroIndex < nums.length&&nonZeroIndex< nums.length){
            if(nums[zeroIndex]!=0){
                zeroIndex++;
                nonZeroIndex = zeroIndex; //current nums[zeroIndex]!=0, and it doesn't need replacing, so set nonZeroIndex after zeroIndex++,
                continue;
            }   
            if(nums[nonZeroIndex]==0){
                nonZeroIndex++;
                continue;
            } 
            nums[zeroIndex] = nums[nonZeroIndex];
            nums[nonZeroIndex] = 0;
            zeroIndex++;
            nonZeroIndex++;
        } 
    }
}
