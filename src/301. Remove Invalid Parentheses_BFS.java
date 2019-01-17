ref: "https://leetcode.com/problems/remove-invalid-parentheses/discuss/75032/Share-my-Java-BFS-solution"
BFS

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        
        if (s == null) return res;
        // remove duplicate
        Set<String> visited = new HashSet<>(); 
        Queue<String> queue = new LinkedList<>();
      
        // initialize
        queue.add(s);
        visited.add(s);
      
        boolean found = false;
      
        while (!queue.isEmpty()) {
          
            s = queue.poll();
        
            if (isValid(s)) {                
                // found an answer, add to the result
                res.add(s);
                found = true;
            }
      
            if (found) continue; // when found and the queue is empty(no other possibilities), return res
      
            // generate all possible states
            for (int i = 0; i < s.length(); i++) {
            
                // we only try to remove left or right paren
                if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

                // remove parenthese at index i 
                String t = s.substring(0, i) + s.substring(i + 1);
        
                if (!visited.contains(t)) {                
                    // for each state, if it's not visited, add it to the queue
                    queue.add(t);
                    visited.add(t);
                }
            }
        }
        
        return res;
    }
    
    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        
        int count = 0;
    
        for (int i = 0; i < s.length(); i++) {            
            char c = s.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
    
        return count == 0;       
    }
}