public void nextPermutation(int[] nums) {
    if(nums == null || nums.length <= 1)  return;
    boolean flag = true; // use flag to see if there is go up trend
    for(int i = nums.length - 1; i > 0; i--){
         if(nums[i] > nums[i-1]){
             if(flag){
                 swap(nums,i,i-1); //no go up trend
                 return;  
             }else{
                 reverse(nums, i, nums.length - 1);
                 int index = findNext(nums, nums[i-1], i); // binary serach
                 swap(nums,index,i-1);
                 return;
             }
         }
         else{
             flag = false;    
         }
    }  
    reverse(nums,0,nums.length-1);     
}

public int findNext(int[] nums, int target, int start){
    int lo = start;
    int hi = nums.length - 1;
    int mid = lo + (hi - lo)/2;
    while(lo<hi){
        if(nums[mid]>target){
           hi = mid;
        }else{
           lo = mid + 1;
        }
    }
    return hi;
}

public void reverse(int[] nums, int start, int end){
    while(start<end){
        swap(nums,start++,end--);
    }
}
public void swap(int[] nums, int m, int n){
    int tmp = nums[m];
    nums[m] = nums[n];
    nums[n] = tmp;
}
