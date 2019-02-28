class Solution {
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        String[] a = s.split(" ");
        int n = a.length;
        String res = "";
        for (int i = n - 1; i >= 0; i--){
            res = res + " " + a[i];
        }
        return res.trim().replaceAll("\\s+"," ");
        // \\s表示空格,回车,换行等空白符, +号表示一个或多个的意思
    }
}