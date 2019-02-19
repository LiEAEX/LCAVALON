Runtime: 2 ms, faster than 43.69% of Java online submissions for Set Matrix Zeroes.
Memory Usage: 47.6 MB, less than 100.00% of Java online submissions for Set Matrix Zeroes.

class Solution {
    public void setZeroes(int[][] matrix) {
        
        HashSet<Integer> row = new HashSet();
        HashSet<Integer> column = new HashSet();
        
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        
        for (int a : row){
            for (int j = 0; j < matrix[0].length; j++){
                matrix[a][j] = 0;
            }
        }
        
        for (int b : column){
            for (int i = 0; i < matrix.length; i++){
                matrix[i][b] = 0;
            }
        }
    }
}