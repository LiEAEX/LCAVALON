// Greedy

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        int res = 0;
        
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int a = intervals[0][0], b = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= b) {
                b = intervals[i][1];
                continue;
            }
            res++;
        }
        return res;
    }
}