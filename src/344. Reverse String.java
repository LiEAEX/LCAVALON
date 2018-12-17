class Solution {
    public String reverseString(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i > -1; i--){
            sb.append(c[i]);
        }
        return sb.toString();        
    }
}