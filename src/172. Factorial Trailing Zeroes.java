// trailing zeros:末尾的0的个数


末尾0的个数，相当于找阶乘中2*5的个数，有5前面一定会有更多的2对应，故就是找所含5的个数就是0的个数
eg: 25/5 = 5, 5/5 = 1   res = 5 + 1 = 6 (25 20 15 10 5: 5*5 4*5 3*5 2*5 1*5)

class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n > 0){
            res += n/5;
            n /= 5;
        }
        return res;
    }
}