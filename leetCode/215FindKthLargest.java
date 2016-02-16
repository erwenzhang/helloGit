public class Solution {
    public int findKthLargest(int[] num,int k){
    	k = num.length - k; // change kth largest to kth element
    	int lo = 0;
    	int hi = num.length-1;
    	while(lo<hi){
    		int pivot = num[(int)(Math.random()*(hi-lo))+lo];
    		int l = lo,cur = lo;
    		int h = hi;
    		while(cur<=h){   //cur<=h , not cur<h
        	    if(num[cur]>pivot){
        	        swap(num,cur,h--);
                }else if(num[cur]<pivot){
                    swap(num,cur++,l++);
                }else{
                    cur++;
                }
        }
        if(k>=l&&k<=h) return num[l];  //[l,h] is pivot range
        else if(k<l) { hi=l-1;}
        else {lo = h+1; }
      }
    return num[lo];
	
  }
    public void swap(int[] nums,int x,int y){
    	int tmp = nums[x];
    	nums[x]=nums[y];
    	nums[y] = tmp;
    }
}
