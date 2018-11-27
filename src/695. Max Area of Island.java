class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++){        // 行
            for (int j = 0; j < grid[0].length; j++){ // 列
                if (grid[i][j] == 1){
                    int count = 0;
                    count = dfs(i, j, count, grid);
                    //max = count > max ? count:max;
                    max = Math.max(count, max);
                }
            }
        }
        return max;
    }
    
    public int dfs(int i, int j, int count, int[][] grid){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            count++;
            count = dfs(i + 1, j, count, grid);
            count = dfs(i, j + 1, count, grid);
            count = dfs(i - 1, j, count, grid);
            count = dfs(i, j - 1, count, grid);
        }
        return count;
    }    
}