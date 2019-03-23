Runtime: 2 ms, faster than 100.00% of Java online submissions for Minesweeper.
Memory Usage: 41.1 MB, less than 43.88% of Java online submissions for Minesweeper.

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int a = click[0], b = click[1];
        if (board[a][b] == 'M'){
            board[a][b] = 'X';
            return board;
        }
        revealHelper(board, a, b);        
        return board;
    }
    
    private void revealHelper(char[][] board, int a, int b){
        if(a < 0 || a > board.length-1 || b < 0 || b > board[0].length-1 || board[a][b] != 'E') return; //注意board长宽是可以不同的。。。
        if (check(board, a, b) == 0){
            board[a][b] = 'B';
            revealHelper(board, a-1, b);
            revealHelper(board, a+1, b);
            revealHelper(board, a, b-1);
            revealHelper(board, a, b+1);
            revealHelper(board, a-1, b-1);
            revealHelper(board, a-1, b+1);
            revealHelper(board, a+1, b-1);
            revealHelper(board, a+1, b+1);
        } else if (check(board, a, b) > 0){            
            board[a][b] = (char)(check(board, a, b) +'0');
        }         
    }
    
    private int check(char[][] board, int a, int b){ //M和X都算雷，注意了。。。
        int res = 0;
        if (a-1>=0 && (board[a-1][b] == 'M'|| board[a-1][b] == 'X')) res += 1;
        if (a+1<board.length && (board[a+1][b] == 'M'|| board[a+1][b] == 'X')) res += 1;
        if (b-1>=0 && (board[a][b-1] == 'M'|| board[a][b-1] == 'X')) res += 1;
        if (b+1<board[0].length && (board[a][b+1] == 'M'|| board[a][b+1] == 'X')) res += 1;
        if (a-1>=0 && b-1>=0 && (board[a-1][b-1] == 'M'|| board[a-1][b-1] == 'X')) res += 1;
        if (a-1>=0 && b+1<board[0].length && (board[a-1][b+1] == 'M'|| board[a-1][b+1] == 'X')) res += 1;
        if (a+1<board.length && b-1>=0 && (board[a+1][b-1] == 'M'|| board[a+1][b-1] == 'X')) res += 1;
        if (a+1<board.length && b+1<board[0].length && (board[a+1][b+1] == 'M'|| board[a+1][b+1] == 'X')) res += 1;
        return res;
    }
}