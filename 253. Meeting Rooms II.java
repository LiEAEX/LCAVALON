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
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] S = new int[n];
        int[] E = new int[n];
        for (int i = 0; i < n; i++){
            S[i] = intervals[i].start;
            E[i] = intervals[i].end;
        }
        Arrays.sort(S);
        Arrays.sort(E);
        int max = 0, count = 0, i = 0, j = 0;
        while (i < n && j < n){
            if (S[i] < E[j]){
                i++;
                count++;
                max = Math.max(max, count);
                continue;
            }
            if (S[i] > E[j]){
                j++;
                count--;
                max = Math.max(max, count);
                continue;
            }
            if (S[i] == E[j]){
                j++;
                i++;
                max = Math.max(max, count);
                continue;
            }
        }
        return max;
    }
}