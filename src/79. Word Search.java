Runtime: 6 ms, faster than 100.00% of Java online submissions for Word Search.
Memory Usage: 40.2 MB, less than 43.99% of Java online submissions for Word Search.

class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(dfs(board, visited, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, boolean[][] visited, int a, int b, int index, String word){        
        if (word.length() == index){
            return true;
        }
        if (a < 0 || b < 0 || a >= board.length || b >= board[0].length) return false;
        char ch = word.charAt(index);
        if (!visited[a][b] && ch == board[a][b]){
            visited[a][b] = true;
            boolean res = dfs(board,visited,a-1,b,index+1,word)|| dfs(board,visited,a+1,b,index+1,word)||dfs(board,visited,a,b-1,index+1,word)|| dfs(board,visited,a,b+1,index+1,word);
            visited[a][b] = false;
            return res;
        }
        return false;
    }
}


class Solution {
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}

