class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int a = 0, b = 0;
        for (int i=0; i< m+n; i++){
            if (a < m && b < n) {
                if (nums1[a] < nums2[b]) {
                    res[i] = nums1[a];
                    a = a + 1;
                }
                else {
                    res[i] = nums2[b];
                    b = b + 1;
                }
            }
            else if (a < m && b >= n) {
                res[i] = nums1[a];
                a = a + 1;
            }
            else if (a >= m && b < n) {
                res[i] = nums2[b];
                b = b + 1;
            }
            //else return;
        }
      for (int i=0; i< m+n; i++) nums1[i] = res[i];  
    }
}