class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i += 2 * k){
            int temp = Math.min(len - 1, i + k - 1);
            reverse(arr, i, temp);
        }
        
        return String.valueOf(arr);
    }
    
    public void reverse(char[] arr, int a, int b){
        while (a < b){
            char tp = arr[a];
            arr[a] = arr[b];
            arr[b] = tp;
            a++;
            b--;
        }
    }
}


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
