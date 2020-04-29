Dynamic Programming
dp[n] indicates that the perfect squares count of the given n, and we have:
dp[0] = 0 
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
      = Min{ dp[3]+1, dp[0]+1 } 
      = 1				
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
      = Min{ dp[4]+1, dp[1]+1 } 
      = 2
						.
						.
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
       = 2
						.
						.
						.
dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

/-----------------------------------------------------------------------/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for(int i = 1; i <= n; i++) {
		    int count = Integer.MAX_VALUE;
		    int j = 1;
		    while(i - j*j >= 0) {
			    count = Math.min(count, dp[i - j*j] + 1);
			    j++;
		    }
		    dp[i] = count;
	    }		
	    return dp[n];
    }
}


BFS:

class Solution {
    public int numSquares(int n) {
        List<Integer> ascendOrder = generateSquares(n);
        Queue<Integer> q = new LinkedList<>();
        boolean[] find = new boolean[n + 1];
        q.add(n);
        int res = 0;
        
        while (q.size() > 0){
            int len = q.size();
            res++;
            while (len > 0){
                int cur = q.poll();
                for (int a: ascendOrder){
                    int temp = cur - a;
                    if (temp == 0) return res;
                    if (temp < 0) break;
                    if (temp > 0 && find[temp] == false){
                        find[temp] = true;
                        q.add(temp);
                    }
                }
                len--;
            }
        }
        return n;  
    }
    
    private List<Integer> generateSquares(int n){
        List<Integer> temp = new ArrayList<>();
        int diff = 3;
        int cum = 1;
        while (cum <= n){
            temp.add(cum);            
            cum = cum + diff;
            diff = diff + 2;            
        }
        return temp;
    }
}
