class Solution {
    public void solveSudoku(char[][] board) {
        if (board.length == 0 || board.length != 9 || board[0].length != 9) return;
        //board.length行长度；；board[i].length列长度
        solveSudokuDFS(board, 0, 0);
    }
    boolean solveSudokuDFS(char[][] board, int i, int j) {
        if (i == 9) return true;
        if (j >= 9) return solveSudokuDFS(board, i + 1, 0);
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; ++k) {
                board[i][j] = (char)(k + '0');//k为int型，k + '0'把k转化为k所对应的ASCII码
                if (isValid(board, i , j)) {
                    if (solveSudokuDFS(board, i, j + 1)) return true;
                }
                board[i][j] = '.';
            }
        } else {
            return solveSudokuDFS(board, i, j + 1);
        }
        return false;
    }
    boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; ++col) {
            if (col != j && board[i][j] == board[i][col]) return false;
        } //check每行里的重复
        for (int row = 0; row < 9; ++row) {
            if (row != i && board[i][j] == board[row][j]) return false;
        } //check每列里的重复
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; ++row) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; ++col) {
                if ((row != i || col != j) && board[i][j] == board[row][col]) return false;
            }
        } //check每个九宫格里的重复
        return true;
    }
}