public class Solution {
    public int findKthElement(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int l = lo;
            int h = hi;
            int cur = l;
            int pivot = nums[(int)Math.random()*(hi-lo)+lo];
            while(cur<=h){
                if(nums[cur]<pivot){
                    swap(nums,cur++,l++);
                }else if(nums[cur]>pivot){
                    swap(nums,cur,h--);
                }else{
                   cur++;
                }
        }
        if(k>=l&&k<=h){
            return nums[l];
        }else if(k<l){
            hi = l - 1;
        }else{
            lo = h + 1;
        }
    }
    return nums[lo];        
}


 public void wiggleSort(int[] nums) {
     int median = findKthElement(nums,(nums.length+1)/2);
     int lo = 0;
     int hi = nums.length - 1;
     int cur = lo;
     int n = nums.length;
     while(cur<=hi){
        if(nums[newIndex(cur,n)] < median){ // also use virtual index for this condition!!!
            swap(nums,newIndex(cur,n),newIndex(hi--,n));
        }else if(nums[newIndex(cur,n)] > median){
            swap(nums,newIndex(cur++,n),newIndex(lo++,n));
        }else{
            cur++;
        } 
     }  
 }

public int newIndex(int cur, int len){
   return (cur*2+1)%(len|1);  
}
public void swap(int[] nums, int i,int j){
   int tmp = nums[i];
   nums[i] = nums[j];
   nums[j] = tmp;
}
}
