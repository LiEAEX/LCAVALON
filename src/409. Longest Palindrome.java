class Solution {
    public int longestPalindrome(String s) {
        int[] cnt = new int[128];
        for (char c : s.toCharArray()){
            cnt[c]++;
        }
        
        int len = 0;
        for (int temp : cnt){
            len += temp / 2 * 2;
        }
        
        if (len < s.length()) {
            len++;
        }
        
        return len;
    }
}


Get the count of char in array of size 128 for ASCII or 256 for extended ASCII

ASCII abcd... ABCD... are in range 128

ASCII TABLE ref: https://www.ascii-code.com/