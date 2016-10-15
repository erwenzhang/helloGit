public int findPeakElement(int[] nums){
    int start = 0;
    int end = nums.length - 1;
    while(start<end){
        int midIndex = (start+end)/2;
        if(nums[midIndex] < nums[midIndex+1]){
           start = midIndex+1;
        }else{
           end = midIndex;
        }
    }
    return start;
}
