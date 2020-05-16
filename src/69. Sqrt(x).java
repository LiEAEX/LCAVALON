// 二分 O(logN)

/* https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20题解%20-%20二分查找.md */

class Solution {
    public int mySqrt(int x) {  
        if (x <= 1) return x;
        int l = 0, h = x, m = 0, sqrt = 0;
        while (l <= h) {
            m = l + (h - l) / 2;
            sqrt = x / m;
            if (sqrt == m) {
                return sqrt;
            } else if (sqrt > m) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return h;
    }
}

// 注意int的范围， 此处必须用long，不然计算结果？？？
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long res = 1;
        while (res * res <= x){
            res++;
        }
        return (int)res - 1;
        
    }
}