Runtime: 2 ms, faster than 99.92% of Java online submissions for Reverse Words in a String II.
Memory Usage: 42.6 MB, less than 14.46% of Java online submissions for Reverse Words in a String II.

class Solution {
    public void reverseWords(char[] str) {
        reverseHelper(str, 0, str.length - 1);
        
        int j = 0;
        for (int i = 0; i < str.length; i++){
            if (str[i] == ' '){
                reverseHelper(str, j, i - 1);
                j = i + 1;
            }
        }
        reverseHelper(str, j, str.length - 1);        
    }
    
    private void reverseHelper(char[] str, int s, int e){
        int start = s, end = e;
        while(start < e && end >= s){            
            char temp = 'a';
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            if (start == end - 1 || start == end) break;
            start++;
            end--;
        }
    }
}