class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() == 1) return 0;
        int res = 0;
        int crt = 1, pre = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                crt++;
            } else {
                pre = crt;
                crt = 1;
            }
            if (pre >= crt) res++;
        }
        return res;
    }
}