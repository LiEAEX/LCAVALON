class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] b:buildings) {
            height.add(new int[]{b[0], -b[2]}); // start point & -height
            height.add(new int[]{b[1], b[2]});  // end point & height
        }
        Collections.sort(height, (a, b) -> {
                if(a[0] != b[0]){
                    return a[0] - b[0]; //different x coordinates, ascending order
                }
                return a[1] - b[1]; //same x, different height, start to end
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a)); //decending order
        pq.offer(0);
        int prev = 0;
        for(int[] h:height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
        
    }
}