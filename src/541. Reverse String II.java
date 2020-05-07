class Solution {
    public String reverseStr(String s, int k) {
        if (s.length() <= 1) return s;
        
        int len = s.length();
        
        for (int i = 0; i < len; i += 2 * k){
            if (len - i < k){
                s = reverseHelper(s, i, len - 1);
            }
            else {
                s = reverseHelper(s, i, i + k - 1);
            }
        }
        
        return s;
    }
    
    public String reverseHelper(String s, int a, int b){
        StringBuilder sb = new StringBuilder(s);
        while (a < b){
            sb.setCharAt(a, s.charAt(b));
            sb.setCharAt(b, s.charAt(a));
            a++;
            b--;
        }
        return sb.toString();
    }
}