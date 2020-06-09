After one iteration, we will get an array that all elements smaller than the pivot are on the left side of the pivot and all elements greater than the pivot are on the right side of the pviot (assuming we sort the array in ascending order). So, inspired from this, each iteration, we choose a pivot and then find the position p the pivot should be. Then we compare p with the K, if the p is smaller than the K, meaning the all element on the left of the pivot are all proper candidates but it is not adequate, we have to do the same thing on right side, and vice versa. If the p is exactly equal to the K, meaning that we've found the K-th position. Therefore, we just return the first K elements, since they are not greater than the pivot.

Quickselect O(n), worstcase O(n^2)

class Solution { // 8ms
    public int[][] kClosest(int[][] points, int K) {    
        int len =  points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) break;
            if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] A, int l, int r) {
        int[] pivot = A[l];
        while (l < r) {
            while (l < r && compare(A[r], pivot) >= 0) r--;
            A[l] = A[r];
            while (l < r && compare(A[l], pivot) <= 0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}


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
