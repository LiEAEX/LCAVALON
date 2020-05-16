class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return new int[0][0];
        
        Arrays.sort(people, (a, b) -> (a[0] == b[0]? a[1] - b[1] : b[0] - a[0]));
        
        List<int[]> arr = new ArrayList<>();
        
        for (int[] p : people){
            arr.add(p[1], p);
        }
        
        return arr.toArray(new int[people.length][2]);
    }
}


