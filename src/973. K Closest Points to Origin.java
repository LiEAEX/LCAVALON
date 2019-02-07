class Solution { // 17 ms
    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[][] res = new int[K][2];
        int[] ds = new int[n];
        if(points == null || n == 0) return res;
        
        for(int i = 0; i < n; i++){
            ds[i] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
        }
        Arrays.sort(ds);
        
        int j = 0;
        for(int i = 0; i < n; i++){
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < ds[K]){
                res[j][0] = points[i][0];
                res[j][1] = points[i][1];
                j++;
                if (j == K) break;
            }
            
        }
        return res;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]));
        int[][] res = new int[K][2];
        int index = 0;
        for(int[] arr : points) {
            queue.add(arr);
        }
        while(index < K) {
            res[index] = queue.poll();
            index++;
        }
        return res;
    }
}

//
(a, b) -> (a[0]*a[0]+a[1]*a[1])-(b[0]*b[0]+b[1]*b[1]) :

We are overriding comparator of Priority Queue to sort int[] elements in particular order. 
From Java 8 we can use lambada function to override comparator. 
Our comparator function is taking two int[] elements (a, b) and then 
we are storing them in ascending order with respect to their distance from origin (0, 0). 