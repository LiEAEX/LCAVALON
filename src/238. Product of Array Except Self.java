class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n], fwd = new int[n], bwd = new int[n];
        fwd[0] = 1; 
        bwd[n-1] = 1;
        
        for (int i = 1; i < n; i++){
            fwd[i] = fwd[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--){
            bwd[i] = bwd[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++){
            output[i] = fwd[i] * bwd[i];
        }
        
        return output;
    }
}



/*
        int product = 1;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            product = product * nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            output[i] = product / nums[i];
        }
        return output;
*/