class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 0) return null; // edge case
        
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target){
                return new int[]{i + 1, j + 1};
            }
            else if (numbers[i] + numbers[j] > target){
                j--;
            }
            else {
                i++;
            }
        }
        return null;
    }
}