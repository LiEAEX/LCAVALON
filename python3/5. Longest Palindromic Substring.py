class Solution:

    def longestPalindrome(self, s: str) -> str:
        if len(s) == 0: return ''
        if len(s) < 2: return s
        res = ""
        for i in range(0, len(s)):
            res = max(self.helper(s, i, i), self.helper(s, i, i+1), res, key = len)
        return res
    
    def helper(self, s, a, b):
        while a >= 0 and b <= len(s) - 1 and s[a] == s[b]:
            a -= 1
            b += 1
        
        return s[a + 1: b]