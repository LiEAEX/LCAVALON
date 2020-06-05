Runtime: 1 ms, faster than 90.89% of Java online submissions for Toeplitz Matrix.
Memory Usage: 39.7 MB, less than 5.88% of Java online submissions for Toeplitz Matrix.

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        boolean res1 = true;
        boolean res2 = true;
        
        for (int i = 0; i < matrix.length; i++) {
            res1 = res1 && tpcheck(matrix, i, 0);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            res2 = res2 && tpcheck(matrix, 0, j);
        }
        
        return res1 && res2;
    }
    
    public boolean tpcheck(int[][] matrix, int a, int b) {
        if (a + 1 >= matrix.length || b + 1 >= matrix[0].length) return true; // a + 1 < matrix.length && b + 1 < matrix[0].length
        
        if (matrix[a][b] != matrix[a + 1][b + 1]) return false;
        
        return tpcheck(matrix, a + 1, b + 1);

    }
}