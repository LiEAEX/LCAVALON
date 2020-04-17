class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        temp = 0
        start = 0
        dic = {}
        for i, c in enumerate(s):
            if c in dic and start <= dic[c]:                
                start = dic[c] + 1
            else: # c not in dic or c in dic and start > dic[c]
                temp = max(temp, i - start + 1)                
            dic[c] = i
        return temp