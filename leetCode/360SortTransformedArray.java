 public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
            int start = 0, end = nums.length-1;
            int[] res = new int[nums.length];
            int index = a>=0?nums.length-1:0;
            
            while(start<=end){
                if(a>=0){
                    res[index--] = helper(nums[start], a, b, c)>=helper(nums[end], a, b, c)?helper(nums[start++], a, b, c):helper(nums[end--], a, b, c);
                }else{
                    res[index++] = helper(nums[start], a, b, c)>=helper(nums[end], a, b, c)?helper(nums[end--], a, b, c):helper(nums[start++], a, b, c);
                }
            }
            
            return res;
    }
    
   public int helper(int x, int a, int b, int c){
       return a*x*x+b*x+c;
   }
