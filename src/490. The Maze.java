Search in the four possible directions when coming to a stopping point (i.e. a new starting point).
Keep track of places that you already started at in case you roll back to that point.

class Solution {
    
    // DFS Solution
    
    private int[] DIRECTIONS = { 0, 1, 0, -1, 0 };
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] startedHere = new boolean[maze.length][maze[0].length];
        return dfs(maze, startedHere, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] startedHere, int[] start, int[] destination) {
        if (startedHere[start[0]][start[1]]) return false;
        if (Arrays.equals(start, destination)) return true;
        
        startedHere[start[0]][start[1]] = true;
        
        for (int i = 0; i < DIRECTIONS.length - 1; i++) {
            int[] newStart = roll(maze, start[0], start[1], DIRECTIONS[i], DIRECTIONS[i + 1]);
            if (dfs(maze, startedHere, newStart, destination)) return true;
        }
        
        return false;
    }
    
    private int[] roll(int[][] maze, int row, int col, int rowInc, int colInc) {
        while (canRoll(maze, row + rowInc, col + colInc)) {
            row += rowInc;
            col += colInc;
        }        
        return new int[]{row, col};
    }
    
    private boolean canRoll(int[][] maze, int row, int col) {
        if (row >= maze.length || row < 0 || col >= maze[0].length || col < 0) return false;
        return maze[row][col] != 1; // 1 is a wall
    }
}

// BFS Solution
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{1, 0, -1, 0};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            if (curPos[0] == destination[0] && curPos[1] == destination[1]) {
                return true;
            }
            // try four direction until it hits the wall
            for (int direction = 0; direction < 4; direction++) {
                int nx = curPos[0], ny = curPos[1];
                while (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    nx += dx[direction];
                    ny += dy[direction];
                }
                
                //back one step
                // In the while loop, the coordinates might be out of bounds because they could be less than zero or over the row or column limit. 
                // So they need to back up one step. For example, it could be the case that nx < 0 which is invalid. So we need to step back.
                nx -= dx[direction];
                ny -= dy[direction];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}