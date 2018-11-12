class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return "";
        String res = "1";
        while (n - 1 > 0) {
            String cur = "";
            for (int i = 0; i < res.length(); ++i) {
                int cnt = 1;
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    ++cnt;
                    ++i;
                }
                cur += String.valueOf(cnt) + res.charAt(i);
            }
            res = cur;
            n = n - 1;
        }
        return res;
    }
}