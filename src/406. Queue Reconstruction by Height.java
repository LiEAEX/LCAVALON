[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
sort array by the height. (The smaller height has the higher priority. But If people have the same height, 
for example [5,0] and [5,2], we should consider [5,2] first, because it has more people higher or equal to it, 
we can treat it is a little shorter than [5,0]). so after sort, it becomes
[[4,4], [5,2], [5,0], [6,1], [7,1], [7,0]]
(1)[4,4], index = 4,the only position is 4, [][][][][4,4][]
(2)[5,2], index = 2, -> [][][5,2][][4,4][]
(3)[5,0], index = 0, -> [5,0][][5,2][][4,4][]
(4)[6,1], index = 1, the index 1 of remaining unoccupied position ->[5,0][][5,2][6,1][4,4][]
(5)[7,1], index = 1, the index 1 of remaining unoccupied position ->[5,0][][5,2][6,1][4,4][7,1]
(5)[7,0], index = 0, the index 0 of remaining unoccupied position ->[5,0][7,0][5,2][6,1][4,4][7,1]



class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            } 
        });
        List<Integer> list = new ArrayList<>(); // 创建List使得后续能正确插入 (the index 1 of remaining unoccupied position)
        for (int i = 0; i < people.length; i++) {
            list.add(i);
        }
        int[][] res = new int[people.length][2];
        for (int i = 0; i < people.length; i++) {
            int index = list.get(people[i][1]);
            res[index][0] = people[i][0];
            res[index][1] = people[i][1];
            list.remove(people[i][1]);
        }
        return res;
    }
}