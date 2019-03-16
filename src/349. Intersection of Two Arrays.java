class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> t = new HashSet<>();
        for (int a : nums1){
            s.add(a);
        }
        for (int b : nums2){
            if (s.contains(b)) t.add(b);
        }
        int[] res = new int[t.size()];
        int i = 0;
        for (int a : t){
            res[i] = a;
            i++;
        }
        return res;
    }
}