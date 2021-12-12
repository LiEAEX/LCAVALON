class Solution {
    
    // Binary Search Approach, Time complexity: O(nlogn)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}


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
