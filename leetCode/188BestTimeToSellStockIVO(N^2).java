public class Solution {
	public int maxProfit(int K,int[] nums){
	    
		if(nums == null||nums.length <= 1) return 0;
    		int len = nums.length;
       
        	if(K>=len/2){
            		int max_pro = 0;
            		for(int i = 1;i<len;i++){
                		max_pro+=Math.max(0,nums[i]-nums[i-1]);
            		}
            		return max_pro;
        	}
    //profits[k][i] = Math.max(profits[k][i-1],profits[k-1][j-1]+nums[i]-nums[j]); = Math.max(profits[k][i-1],nums[i]+max(profits[k-1][j-1]-nums[j]));
        	int[][] profits = new int[K+1][len];
        	int max = 0;
        	for(int j = 1;j<=K;j++){
	        	int tmp_max = profits[j-1][0]-nums[0];
	        	for(int i = 1;i<len;i++){
	    	    		profits[j][i] = Math.max(profits[j][i-1],tmp_max+nums[i]);
               	 		tmp_max = Math.max(tmp_max,profits[j-1][i-1]-nums[i]);
            		}
        	}
        	return profits[K][len-1];
    }
}
