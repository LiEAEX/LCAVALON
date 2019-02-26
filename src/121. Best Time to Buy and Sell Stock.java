class Solution {
    public int maxProfit(int[] prices) {
		 if (prices.length == 0) {
			 return 0 ;
		 }		
		 int max = 0 ;
		 int buy = prices[0] ;
	     for (int i = 0 ; i < prices.length ; ++i) {
	    	 if (prices[i] > buy) {
	    		 max = Math.max(max, prices[i] - buy) ;
	    	 } else{
	    		buy = prices[i];  
	    	 }
	     }	     
	    return  max ;
	 }
}

Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock.
Memory Usage: 35.7 MB, less than 93.98% of Java online submissions for Best Time to Buy and Sell Stock.
	
class Solution {
    public int maxProfit(int[] prices) {
        int[] min = new int[prices.length];
        int tp = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < prices.length; i++){
            min[i] = Math.min(tp, prices[i]);
            tp = min[i];
        }
        for (int i = 0; i < prices.length; i++){
            res = Math.max(res, prices[i] - min[i]);
        }
        return res;
    }
}
