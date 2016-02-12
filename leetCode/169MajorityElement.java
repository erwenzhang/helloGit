public int majorityElement(int[] nums) {
    int count = 1;
    int target = nums[0]; 
    for(int i = 1;i<nums.length;i++){
	      if(count==0) {
            target = nums[i];
            count=1;
        }else{
            if(nums[i]==target)
		            count++;
	          else
		            count--;
        }
    }  
    return target;    
 }
