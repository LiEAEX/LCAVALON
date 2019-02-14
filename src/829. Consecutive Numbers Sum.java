Runtime: 14 ms, faster than 39.84% of Java online submissions for Consecutive Numbers Sum.
Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Consecutive Numbers Sum.

class Solution {
    public int consecutiveNumbersSum(int N) {
        int ans = 0;
        for (int m = 1; ; m++) {  m为连续数的个数，x为任意连续等差数列的首项（d=1）
            int mx = N - m * (m-1) / 2;
            if (mx <= 0)
                break;
            if (mx % m == 0)
                ans++;
        }
        return ans;
    }
}