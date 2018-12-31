class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wd = new HashSet<>();
        for (String str : wordDict){
            wd.add(str);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == true && wd.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}