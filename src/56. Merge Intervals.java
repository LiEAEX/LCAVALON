/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>(); 
        int n = intervals.size();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = intervals.get(i).start;
            b[i] = intervals.get(i).end;
        }
        Arrays.sort(a);
	    Arrays.sort(b);
        for (int i = 0, j = 0; i < n; i++) {
            // j is start of interval, i is the end
            // 如果i指向a数组中的最后一个位置，或者a数组i+1位置上的数字大于b数组i位置的数时，
            // 此时说明区间已经不连续了
		    if (i == n - 1 || a[i + 1] > b[i]) {
			    res.add(new Interval(a[j], b[i]));
			    j = i + 1;
		    }
	    }
	    return res;
    }
}