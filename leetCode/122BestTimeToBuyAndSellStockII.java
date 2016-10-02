public int maxProfit(int[] prices) {
    int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
}

//Solution 2
public int maxProfit(int[] prices){
        if(prices == null||prices.length<=1) return 0;
        int max = prices[0];
        int min = prices[0];
        int profit = 0;
        for(int i = 1; i< prices.length; i++){
            if(prices[i]<max){ // leave previous up trend, reset min and max, compute profit for previous up trend,
                profit += (max - min);
                max = min = prices[i];      
            }else{
                max = prices[i];
            }   
        }
        profit += (max - min);
        return profit;
}
