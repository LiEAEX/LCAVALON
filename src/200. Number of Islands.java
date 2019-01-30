class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0; //这一句必须有，不然Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 0
        int count = 0;                                                   // 下面的code不能处理input为空的情况
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(i, j, visited, grid);
                } 
            }
        }
        return count;
    }
    private void dfs(int i, int j, boolean[][] visited, char[][] grid){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1' && visited[i][j] == false){
            visited[i][j] = true;
            dfs(i + 1, j, visited, grid);
            dfs(i, j + 1, visited, grid);
            dfs(i - 1, j, visited, grid);
            dfs(i, j - 1, visited, grid);
        }
    }
}

DFS VER2：

public int numIslands(char[][] grid) {
    int count = 0;
    for(int i = 0; i < grid.length; i++)
        for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == '1'){
                dfsFill(grid,i,j);
                count++;
            }
        }
    return count;
}
private void dfsFill(char[][] grid,int i, int j){
    if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1'){
        grid[i][j] = '0';
        dfsFill(grid, i + 1, j);
        dfsFill(grid, i - 1, j);
        dfsFill(grid, i, j + 1);
        dfsFill(grid, i, j - 1);
    }
}
