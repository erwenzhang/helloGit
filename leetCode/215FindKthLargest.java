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
	
    /*Sol2 recursion*/
    public int findKthLargest(int[] num, int k){
        k = num.length - k;
        return helper(num, k, 0 , num.length-1);
    }
    public int helper(int[] num,int k, int lo, int hi){
        int l = lo;
        int h = hi;
        int cur = l;
        int pivot = num[l + (h-l)*(int)Math.random()];
        while(cur<=h){
            if(num[cur]>pivot) swap(num, cur, h--);
            else if(num[cur]<pivot) swap(num,cur++,l++);
            else cur++;
        }
        if(k<l) return helper(num, k, lo, l-1);
        else if(k<=h) return num[k];
        else return helper(num, k, h+1, hi);
    }
}
