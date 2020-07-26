Runtime: 3 ms, faster than 68.74% of Java online submissions for Valid Palindrome.
Memory Usage: 39.9 MB, less than 44.87% of Java online submissions for Valid Palindrome.

class Solution {
    public boolean isPalindrome(String s) {
        String sl = s.toLowerCase();
        if (s == null || s.length() == 0) return true;
        int i = 0, j = sl.length() - 1;
        while (i <= j) {
            while (i <= sl.length() - 1 && !Character.isLetterOrDigit(sl.charAt(i))) i++;
            while (j >=0 && !Character.isLetterOrDigit(sl.charAt(j))) j--;
            if (i <= sl.length() - 1 && j >=0 && sl.charAt(i) != sl.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}