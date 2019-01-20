优化版 beat 42.88%
class Solution {
    public boolean backspaceCompare(String S, String T) {
       return check(S).equals(check(T));
    }
    
    private Stack<Character> check(String str) {
        Stack<Character> a = new Stack<>();
        
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '#' && a.isEmpty()) continue;
            if (str.charAt(i) != '#'){
                a.push(str.charAt(i));
                continue;
            }
            a.pop();
        }
        
        return a;
    }
}

最慢的初版 beat 3%
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        
        for (int i = 0; i < S.length(); i++){
            if (S.charAt(i) == '#' && a.isEmpty()) continue;
            if (S.charAt(i) != '#'){
                a.push(S.charAt(i));
                continue;
            }
            a.pop();
        }
        
        for (int i = 0; i < T.length(); i++){
            if (T.charAt(i) == '#' && b.isEmpty()) continue;
            if (T.charAt(i) != '#'){
                b.push(T.charAt(i));
                continue;
            }
            b.pop();
        }
        
        return a.equals(b);
    }
}