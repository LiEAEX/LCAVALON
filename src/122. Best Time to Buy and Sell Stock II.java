class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; ++i) {
            if (prices[i] < prices[i + 1]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }
}

Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
Memory Usage: 35.4 MB, less than 98.37% of Java online submissions for Best Time to Buy and Sell Stock II.

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int i=0;
        int peak=prices[0];
        int valley=prices[0];
        int maxProfit=0;
        int len=prices.length;
        while (i<len-1){
            while (i<len-1 && prices[i]>=prices[i+1]){//down
                i++;
            }
            valley=prices[i];
            while (i<len-1 && prices[i]<=prices[i+1]){//up
                i++;
            }
            peak = prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}
