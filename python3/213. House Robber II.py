
Runtime: 36 ms, faster than 52.43% of Python3 online submissions for House Robber II.
Memory Usage: 13.8 MB, less than 50.64% of Python3 online submissions for House Robber II.

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 0: return 0
        if len(nums) == 1: return nums[0]
        if len(nums) == 2: return max(nums[0], nums[1])
        return max(self.robHelp(nums[:-1]), self.robHelp(nums[1:]))
    
    def robHelp(self, nums):
        res = [0] * len(nums)
        res[0] = nums[0]
        res[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
            res[i] = max(res[i-2] + nums[i], res[i-1])
        return res[len(nums) - 1]
    
    '''
    Notice that the first house and the last house can not be both robbed, so we have rob(nums) = max(rob(nums[1:], nums[:-1]). 
    Since there are no circles in both nums[1:] and nums[:-1], we can simply apply the answers from House Rob
    '''