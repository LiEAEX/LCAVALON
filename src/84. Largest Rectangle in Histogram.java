class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; ++i) {
            if (i + 1 < heights.length && heights[i] <= heights[i + 1]) {
                continue;
            }
            // 找出局部最大值，然后向前(i--方向)遍历，取最小值，不断更新最大面积
            int minH = heights[i]; 
            for (int j = i; j >= 0; --j) {
                minH = Math.min(minH, heights[j]);
                int area = minH * (i - j + 1);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}