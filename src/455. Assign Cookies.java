// Greedy

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0, j = 0;
        while (i < g.length && j < s.length){
            if (g[i] <= s[j]){
                res++;
                i++;
            }
            j++;
        }
        return res;
    }
}