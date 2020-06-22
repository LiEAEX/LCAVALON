Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Chunks To Make Sorted.
Memory Usage: 36.6 MB, less than 76.99% of Java online submissions for Max Chunks To Make Sorted.

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int rightMax = 0;
        for (int i = 0; i < arr.length; i++) {
            rightMax = Math.max(arr[i], rightMax);
            if (rightMax == i) res++;
        }
        
        return res;
    }
}

ref: https://leetcode.com/problems/max-chunks-to-make-sorted/discuss/113528/Simple-Java-O(n)-Solution-with-detailed-explanation

/** 
    The key to understand this algorithms lies in the fact that when max[index] == index, 
    all the numbers before index must be smaller than max[index] (also index), 
    so they make up of a continuous unordered sequence, i.e {0,1,..., index}
*/