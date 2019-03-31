Runtime: 2 ms, faster than 99.73% of Java online submissions for Add Strings.
Memory Usage: 36.9 MB, less than 95.20% of Java online submissions for Add Strings.

class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        if (m == 0) return num2;
        if (n == 0) return num1;
        
        String res = "";
        StringBuilder sb = new StringBuilder();
        int a = 0, b = 0, c = 0;
        int i = m - 1, j = n - 1;
        while (i >= 0 || j >= 0){
            a = i >= 0? (num1.charAt(i) - '0'):0;
            b = j >= 0? (num2.charAt(j) - '0'):0;
            sb.append((char)((a + b + c)%10 + '0'));
            //  sb.append((a + b + c)%10)  is also OK
            c = (a + b + c)/10;
            i--;
            j--;
        }
        res = sb.reverse().toString();
        if (c > 0){
            return "1" + res;             
        } 
        else return res;        
    }
}

append(int i)
Appends the string representation of the int argument to this sequence.

append(char c)
Appends the string representation of the char argument to this sequence.

append(char[] str)
Appends the string representation of the char array argument to this sequence.
