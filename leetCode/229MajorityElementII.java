 public List<Integer> majorityElement(int[] nums) {
        List<Integer> rets = new ArrayList<>();
        if(nums==null||nums.length==0) return rets;
        int first = 0, count1 = 0,count2 = 0, second = 1;
        for(int i=0;i<nums.length;i++){
             if(nums[i]==first){
	            count1++;
            }else if(nums[i]==second){
	            count2++;
            }else if(count2 == 0){
	            second = nums[i];
                count2 = 1;
            }else if(count1==0){
                first = nums[i];
                count1 = 1;
            }else{
	            count2--;
	            count1--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num:nums){
           if(num==first) count1++;
           else if(num==second) count2++;
        }
        if(count1>nums.length/3) rets.add(first);
        if(count2>nums.length/3) rets.add(second);
        return rets;
 }
