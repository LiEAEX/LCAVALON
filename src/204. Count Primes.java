Runtime: 14 ms, faster than 86.42% of Java online submissions for Count Primes.
Memory Usage: 35.8 MB, less than 1.21% of Java online submissions for Count Primes.

Time complexity here is O(N*Log(LogN)) ,can also be O(N*LogN) (not sure, wharever...)

class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        
        for (int i = 2; i < n; i++){
            if (notPrime[i] == false){
                res++;
                for (int j = 2; i * j < n; j++){
                    notPrime[i * j] = true;
                }
            }
        }
        
        return res;
    }
}