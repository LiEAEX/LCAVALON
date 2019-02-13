Runtime: 13 ms, faster than 15.82% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 46.5 MB, less than 1.00% of Java online submissions for Search a 2D Matrix II.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        boolean res = false;
        
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == target){
                    res = true;
                    return res;
                }
            }
        }
        return res;
    }
}

Runtime: 7 ms, faster than 62.21% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 42.4 MB, less than 1.06% of Java online submissions for Search a 2D Matrix II.

O(n + m)

If we stand on the top-right corner of the matrix and look diagonally, 
"it's kind of like a BST, we can go through this matrix to find the target like how we traverse the BST."

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
    
        while (i < n && j >= 0) {
            int num = matrix[i][j];
        
            if (num == target)
                return true;
            else if (num > target)
                j--;
            else
                i++;
        }
    
        return false;
    }
}
