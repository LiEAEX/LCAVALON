class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'X'){
                    board[i][j] = '.';
                    checkVertival(i, j, board);
                    checkHorizon(i, j, board);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void checkVertival(int row, int col, char[][] board){
        int temp = row;
        while (row > 0 && board[row - 1][col] == 'X'){
            row--;
            board[row][col] = '.';
        }
        row  = temp;
        while (row < board.length-1 && board[row + 1][col] == 'X'){
            row++;
            board[row][col] = '.';
        }
    }
    
    private void checkHorizon(int row, int col, char[][] board){
        int temp2 = col;
        while (col > 0 && board[row][col - 1] == 'X'){
            col--;
            board[row][col] = '.';
        }
        col = temp2;
        while (col < board[0].length-1 && board[row][col + 1] == 'X'){
            col++;
            board[row][col] = '.';
        }
    }
}