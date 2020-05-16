class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int upperbound = (int)Math.sqrt(c);
        int i = 0;
        while (i <= upperbound) {
            if (i * i + upperbound * upperbound == c) return true;
            else if (i * i + upperbound * upperbound > c) upperbound--;
            else i++;
        }
        return false;
    }
}