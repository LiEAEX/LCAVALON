class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        int len = t.length();
        int pnt = 0, cnt = 0;
        for (char c : s.toCharArray()){
            if (pnt >= len) break;
            while (pnt < len && c != t.charAt(pnt)){
                pnt++;
            }
            if (pnt < len && c == t.charAt(pnt)) cnt++;
            pnt++;
        }
        return cnt == s.length();
    }
}