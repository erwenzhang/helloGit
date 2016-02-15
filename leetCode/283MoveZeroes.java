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
    public void moveZeroes(int[] nums){
	    int i = 0;
	    int j = 1;
	    while(i<nums.length){
		    if(nums[i]==0){
                while(j<nums.length&&nums[j]==0){
                    j++;
                }
                if(j==nums.length) break;
                swap(nums,i,j);
            }
            i++;
            if(j<=i) j = i+1;
        }
    }
    
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
