Runtime: 3 ms, faster than 100.00% of Java online submissions for Valid Tic-Tac-Toe State.
Memory Usage: 37.4 MB, less than 5.19% of Java online submissions for Valid Tic-Tac-Toe State.

class Solution {
    public boolean validTicTacToe(String[] board) {
        
        boolean Xwin = false, Owin = false;
        int[] row = new int[3];
        int[] column = new int[3];
        int diag = 0, antidiag = 0, count = 0;
        
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (board[i].charAt(j) == 'X'){
                    count++;
                    row[i]++;
                    column[j]++;
                    if (i == j) diag++;
                    if (i + j == 2) antidiag++;
                }
                if (board[i].charAt(j) == 'O'){
                    count--;
                    row[i]--;
                    column[j]--;
                    if (i == j) diag--;
                    if (i + j == 2) antidiag--;
                }
            }
        }
        
        Xwin = row[0] == 3 || row[1] == 3 || row[2] == 3 || column[0] == 3 || column[1] == 3 || column[2] == 3 || diag == 3 || antidiag == 3;
        Owin = row[0] == -3 || row[1] == -3 || row[2] == -3 || column[0] == -3 || column[1] == -3 || column[2] == -3 || diag == -3 || antidiag == -3;
        
        if (Xwin && count != 1 || Owin && count != 0) return false;
        
        return (!Xwin || !Owin) && (count == 0 || count == 1);
    }
    

}