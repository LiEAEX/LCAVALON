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