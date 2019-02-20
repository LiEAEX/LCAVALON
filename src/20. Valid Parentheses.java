class Solution {
    public boolean isValid(String s) {
       Stack<Character> t = new Stack<Character>();
       for (char c : s.toCharArray()) {
		   if (c == '(')
			   t.push(')');
		   else if (c == '{')
			   t.push('}');
		   else if (c == '[')
			   t.push(']');
		   else if (t.isEmpty() || t.pop() != c)
			   return false;
	    }
	return t.isEmpty(); 
    }
}


Runtime: 4 ms, faster than 98.12% of Java online submissions for Valid Parentheses.
Memory Usage: 34.7 MB, less than 54.04% of Java online submissions for Valid Parentheses.

class Solution {
    public boolean isValid(String s) {
        Stack<Character> t = new Stack();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                t.push(')');
                continue;
            }
		    else if (s.charAt(i) == '{'){
                t.push('}');
                continue;
            }
		    else if (s.charAt(i) == '['){
                t.push(']');
                continue;
            }
            if (t.isEmpty() || t.pop() != s.charAt(i)) return false;
        }
        return t.size() == 0;
    }
}