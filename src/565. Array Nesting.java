class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = i; !visited[j]; temp++) { // 重复元素找到后理解为形成一个环，每个环内的数字是固定的（故环内任何数字进入环都不影响S的长度）
                visited[j] = true;                 // ，故可以每次找完一个环后就不需要再找环中的元素
                res = Math.max(res, temp);         // eg: A = [5,4,0,3,1,6,2]  s[0] = {5, 6, 2, 0} s[1] = {4, 1} s[3] = {3} 可形成3个不同的环
                j = nums[j];                       // 其他的例子： s[2] = {0, 5, 6, 2} s[4] = {1，4}
            }
        }
        return res;
    }
}
