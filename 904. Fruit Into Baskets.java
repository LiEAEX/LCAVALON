// Longest Subarray with at most 2 Distinct elements
class Solution {
    public int totalFruit(int[] tree) {
        int start = 0, n = tree.length;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(tree[i], i);
            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());//返回最小的value
                map.remove(tree[minIndex]);
                start = minIndex + 1;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}