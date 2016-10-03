public class Solution {
	public int maxProfit(int K, int[] nums){
	if(nums == null||nums.length == 0) return 0;
	int len = nums.length;
    	int [] profits = new int[len];
        //profits[k][i] = Math.max(profits[k][i-1],profits[k-1][j]+nums[i]-nums[j]);
       // Math.max(profits[k][i-1],nums[i]+max(profits[k-1][j]-nums[j]));
       // profits[i] is used to store the latest k 
   	if(K>=len/2){
    		int max = 0;
    		for(int i = 1;i<len;i++){
    			max+=Math.max(0,nums[i]-nums[i-1]);
    		}
        	return max;
    	}
    	for(int k=1;k<=K;k++){
	    int tmp_max = profits[0]-nums[0];
	    for(int i = 1;i<len;i++){
            tmp_max = Math.max(tmp_max,profits[i]-nums[i]);
            profits[i] = Math.max(profits[i-1],tmp_max+nums[i]);
        }	
    }   
        return profits[len-1];
    }
}
