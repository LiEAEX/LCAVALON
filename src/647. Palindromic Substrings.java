class Solution {
    
    private int cnt = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++){
            countPalindromic(s, i, i); // even
            countPalindromic(s, i, i + 1); // odd
        }
        return cnt;
    }
    
    public void countPalindromic(String s, int a, int b) {
        while (a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
            a--;
            b++;
            cnt++;
        }
    }
}