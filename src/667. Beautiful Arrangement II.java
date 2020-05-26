Runtime: 1 ms, faster than 62.86% of Java online submissions for Beautiful Arrangement II.
Memory Usage: 39.7 MB, less than 25.00% of Java online submissions for Beautiful Arrangement II.

class Solution {
    public int[] constructArray(int n, int k) {
        int copy = k;
        int[] res = new int[n];
        res[0] = 1;
        if (n == 1) return res;
        int i = 1;
        while (copy >= 1) {
            res[i] = res[i - 1] + (int) Math.pow(-1, i - 1) * copy;
            copy--;
            i++;
        }
        while (i < n) {
            res[i] = i + 1;
            i++;
        }
        return res;
    }
}