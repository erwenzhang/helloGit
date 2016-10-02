public class Solution {
        /*Two DP, one from left, one from right*/
	public int maxProfit(int[] prices){
        	if(prices == null||prices.length<=1) return 0;
        	int[] left = new int[prices.length];
        	int[] right = new int[prices.length];
        	int min = prices[0];
        	int max = prices[0];
        	left[0] = 0;
        	for(int i = 1; i < prices.length; i++){
            		if(prices[i]<min){
                		left[i] = Math.max(max-min, left[i-1]);
                		min = max = prices[i];
            		}else if(prices[i]>max){
                		max = prices[i];
                		left[i] = max - min;
            		} else{
                		left[i] =left[i-1];
            		}         
         	}
         	min = prices[prices.length-1];
         	max = min;
         	right[prices.length-1] = 0;
         	for(int i = prices.length-2; i >=0 ; i--){
             		if(prices[i] > max){
                 		right[i] = Math.max(max-min,right[i+1]);
                 		min = max = prices[i];
             		}else if(prices[i] < min){
                  		min = prices[i];
                  		right[i] = max - min;
             		} else{
                		right[i] =right[i+1];
            		}
         	}
         	int profit = 0;
         	for (int i = 0; i < prices.length; i++){
             		profit = Math.max(left[i] + right[i], profit);  
         	}
         	return profit;
    	}
	
   public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }

        //DP from right to left;
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = Math.max(left[i] + right[i], profit);  
        }

        return profit;
    }
}
