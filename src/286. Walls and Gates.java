BFS

class Solution {
    public void wallsAndGates(int[][] rooms) {
        //if (rooms.length == 0 || rooms[0].length == 0) return;
        
        int[] pos = new int[2];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                if (rooms[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        // first add all gates in queue, then do BFS
        // the purpose is to ensure that INF is updated with a distance from its nearest 0
        while (!q.isEmpty()){
            int len = q.size(); 
            for (int i = 0; i < len; i++){
                pos = q.poll();
                if (pos[0]-1>=0 && rooms[pos[0]-1][pos[1]]==Integer.MAX_VALUE){
                    rooms[pos[0]-1][pos[1]] = rooms[pos[0]][pos[1]] + 1;
                    q.offer(new int[]{pos[0]-1, pos[1]});
                }
                if (pos[0]+1<rooms.length && rooms[pos[0]+1][pos[1]]==Integer.MAX_VALUE){
                    rooms[pos[0]+1][pos[1]] = rooms[pos[0]][pos[1]] + 1;
                    q.offer(new int[]{pos[0]+1, pos[1]});
                }
                if (pos[1]-1>=0 && rooms[pos[0]][pos[1]-1]==Integer.MAX_VALUE){
                    rooms[pos[0]][pos[1]-1] = rooms[pos[0]][pos[1]] + 1;
                    q.offer(new int[]{pos[0], pos[1]-1});
                }
                if (pos[1]+1<rooms[0].length && rooms[pos[0]][pos[1]+1]==Integer.MAX_VALUE){
                    rooms[pos[0]][pos[1]+1] = rooms[pos[0]][pos[1]] + 1;
                    q.offer(new int[]{pos[0], pos[1]+1});
                }
            }
        }    
    }
    
}

DFS

class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[0].length; j++){
                 if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    
    private void dfs(int[][] rooms, int row, int col, int distance){
        if (row<0 || row>rooms.length-1 || col<0 || col>rooms[0].length-1 || rooms[row][col]<distance) return;
        rooms[row][col] = distance;
        dfs(rooms, row-1, col, distance+1);
        dfs(rooms, row+1, col, distance+1);
        dfs(rooms, row, col-1, distance+1);
        dfs(rooms, row, col+1, distance+1);
    }
}