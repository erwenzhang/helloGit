public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], max = prices[0], rst = max - min;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
                rst = Math.max(rst, max - min);
            }
        }
        return Math.max(0, rst);
    }
}
