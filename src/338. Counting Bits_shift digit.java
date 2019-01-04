class Solution {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
// An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.

/* f[1] = (f[0]==0) + (1%1==1) = 1
   f[11] = (f[1]==1) + (11%1==1)  = 2
   f[110] = (f[11]==2) + (110%1==0) = 2
   f[1101] = (f[110] ==2) + (1101%1==1) =3;
*/