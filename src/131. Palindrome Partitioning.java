Runtime: 1 ms, faster than 100.00% of Java online submissions for Palindrome Partitioning.
Memory Usage: 40.2 MB, less than 82.04% of Java online submissions for Palindrome Partitioning.

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if ((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
            }
        }
        findHelper(res, dp, s, new ArrayList<>(), 0);
        return res;
    }
    
    public void findHelper(List<List<String>> res, boolean[][] dp, String s, List<String> temp, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (dp[pos][i]) {
                temp.add(s.substring(pos, i+1));
                findHelper(res, dp, s, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}