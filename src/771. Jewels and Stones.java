class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] a = J.toCharArray();
        char[] b = S.toCharArray();
        int count = 0;
        for (char c : a){
            for (int i = 0; i < b.length; i++){
                if (b[i] == c) count++;
            } 
        }
        return count;
    }
}