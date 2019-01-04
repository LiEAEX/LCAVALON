class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int temp = 0;
        for(int i = 0; i < num + 1; i++){
            int count = 0, n = i;
            while(true){
                temp = n % 2;
                n = n / 2;
                if(temp == 1 && n >= 1) count++;
                if(temp == 1 && n == 0){
                    count++;
                    break;
                }
                if(temp == 0 && n == 0) break; //when num = 0
            }
            res[i] = count;
        }
        return res;
    }
}