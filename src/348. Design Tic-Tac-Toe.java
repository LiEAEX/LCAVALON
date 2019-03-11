Runtime: 57 ms, faster than 76.30% of Java online submissions for Design Tic-Tac-Toe.
Memory Usage: 47.7 MB, less than 7.25% of Java online submissions for Design Tic-Tac-Toe.

class TicTacToe {

    /** Initialize your data structure here. */
    int bd = 0;
    int[][] game;
    public TicTacToe(int n) {
        bd = n;
        game = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int res = 0;
        if (player == 1){
            game[row][col] = 1;
            res = check(row, col, game, 1, bd);
        }
        else if (player == 2){
            game[row][col] = 2;
            res = check(row, col, game, 2, bd);
        }
        return res;
    }
    
    public int check(int row, int col, int[][] game, int player, int m){
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        for (int i = 0; i < m; i++){
            if (game[row][i] == player) count1++;
            else if (game[row][i] != player) break;
        }
        for (int i = 0; i < m; i++){
            if (game[i][col] == player) count2++;
            else if (game[i][col] != player) break;
        }
        if (row == col){
            for (int i = 0; i < m; i++){
                if (game[i][i] == player) count3++;
                else if (game[i][i] != player) break;
            }           
        }
        for (int i = 0; i < m; i++){
            if (game[m - 1 - i][i] == player) count4++;
            else if (game[m - 1 - i][i] != player) break;
        } 
        
        if (count1 == m || count2 == m || count3 == m || count4 == m) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */