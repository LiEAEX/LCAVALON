class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] a = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < numbers.length; i++) {
        map.put(numbers[i], i);
    }
        for (int i = 0; i < numbers.length; i++){
            int k = target - numbers[i];
            if (map.containsKey(k)&&map.get(k) != i){               
                a[0] = i;
                a[1] = map.get(k);
                return a;
            }           //存储差值为key,下标为value
        }
        return new int[2];
    }
}
