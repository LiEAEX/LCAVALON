class Solution {
    public int[] plusOne(int[] digits) {
        int l = digits.length;
        
            for (int i = l-1; i >= 0; i--){
                if (digits[i] == 9){
                    digits[i] = 0;
                    if (digits[0] == 0) {
                        int[] res = new int[l+1];
                        for (int j = 1; j < l+1; j++){
                            res [j] = digits[j-1];
                        }
                        res[0] = 1;
                        return res;
                    }
                }
                else {
                    digits[i] = digits[i] + 1;
                    break;
                }
            }
        return digits;
    }
}