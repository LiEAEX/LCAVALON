class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) return nums;
        int[][] res = new int[r][c];
        
        int i = 0, j = 0;
        for (int[] rowarray : nums){
            for (int value : rowarray) {
                if (i < r && j < c) {
                    res[i][j] = value;
                    j++;
                    continue;
                }
                j = 0;
                i++;
                res[i][j] = value;
                j++;
            }
        }        
        return res;
    }
}

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row * col != r * c) return nums;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++){
            res[i / c][i % c] = nums[i / col][i % col];
        }        
        return res;
    }
}