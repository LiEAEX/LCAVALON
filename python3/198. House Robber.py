Runtime: 28 ms, faster than 87.58% of Python3 online submissions for House Robber.
Memory Usage: 13.8 MB, less than 49.49% of Python3 online submissions for House Robber.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]
        if len(nums) == 2: return max(nums[0], nums[1])
        res = [0] * len(nums)
        res[0] = nums[0]
        res[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            res[i] = max(res[i-2] + nums[i], res[i-1])
        return res[len(nums) - 1]
    
 
Runtime: 32 ms, faster than 71.41% of Python3 online submissions for House Robber.
Memory Usage: 14 MB, less than 21.85% of Python3 online submissions for House Robber.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]
        rob, no_rob = 0, 0
        for i in range(len(nums)):
            rob, no_rob = no_rob + nums[i], max(rob, no_rob)
        return max(rob, no_rob)
