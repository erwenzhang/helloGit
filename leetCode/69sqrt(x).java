public class Solution {
    public int mySqrt(int x){
    	int lo = 0;
    	int hi = Integer.MAX_VALUE;
    	int mid = lo + (hi-lo)/2;
    	while(lo<=hi){
    	    mid = lo + (hi-lo)/2;
    	    long product =(long)mid * mid;
    		if(product<x){
    		    if((long)((mid+1)*(mid+1))>x)
        				return mid;
    		    lo = mid+1;
         }else if(product>x){
            	hi = mid-1;
         }else{
            	return mid;
         }
      }
      return hi;
    }


}
