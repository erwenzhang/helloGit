public class Solution {
    public int[] productExceptSelf(int[] nums) {
    	if(nums==null||nums.length==0) return nums;
    	int[] foward = new int[nums.length];
    	int[] backward = new int[nums.length];
    	foward[0] = 1;
    	int indx = nums.length - 1;
    	backward[indx] = 1;
    	for(int i = 1; i < nums.length; i++){
        	foward[i] = foward[i-1]*nums[i-1];
        	backward[indx-i] = backward[indx-i+1]*nums[indx-i+1];
    	} 
    
    	for(int i = 0; i < nums.length; i++){
        	nums[i] = backward[i]*foward[i];
    	}  
    	return nums;      
    }
    
    /*Follow up, o(1) space*/
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1; i<nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        int right = 1;
        for(int i=nums.length-1; i>=0; i--){
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        return res;
    }
}
