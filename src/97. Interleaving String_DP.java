class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean res = false;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : s1.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (char c : s3.toCharArray()){
            if (!m.containsKey(c)) return res;
            m.put(c, m.get(c) - 1);
        }
        for (int num : m.values()){
            if (num != 0) return res;
        }
        
        // dp[i][j] = true, means first i characters of s1 and first j characters of s2 interleaved to form i+j characters of s3
        boolean dp[][] = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        
        // case 1
        for (int i = 1; i <= s1.length(); i++){
            if((s1.substring(0,i)).equals(s3.substring(0,i))){
                dp[i][0] = true;
            } else {
                dp[i][0] = false;
            }
        }

        // case 2
        for (int j = 1; j <= s2.length(); j++){
            if ((s2.substring(0,j)).equals(s3.substring(0,j)))
                dp[0][j] = true;
            else
                dp[0][j] = false;
        }
        
        //dp solution
        for (int i = 1;i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if((dp[i-1][j] == true && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] == true && s2.charAt(j-1) == s3.charAt(i+j-1))){
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}