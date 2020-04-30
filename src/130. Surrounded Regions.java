class Solution {
    public void solve(char[][] board) {
        if (board.length <= 2) return;
        
        int m = board.length, n = board[0].length;
        boolean[][] checkO = new boolean[board.length][board[0].length];
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O'){
                dfs(board, i, 0, checkO);
            } 
            if (board[i][n - 1] == 'O'){
                dfs(board, i, n - 1, checkO);
            }
        }
        
        for (int j = 0; j < n; j++){
            if (board[0][j] == 'O'){
                dfs(board, 0, j, checkO);
            }
            if (board[m - 1][j] == 'O'){
                dfs(board, m - 1, j, checkO);
            }
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (checkO[i][j] == false && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
        return;
        
    }
    
    private void dfs(char[][] board, int a, int b, boolean[][] checkO){
        if (a >= 0 && a < board.length && b >= 0 && b < board[0].length && board[a][b] == 'O' && checkO[a][b] == false){
            checkO[a][b] = true;
            dfs(board, a-1, b ,checkO);
            dfs(board, a, b-1 ,checkO);
            dfs(board, a+1, b ,checkO);
            dfs(board, a, b+1 ,checkO);
        }
        return;
    }
}