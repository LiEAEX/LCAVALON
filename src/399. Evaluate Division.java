class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Set<String> s = new HashSet<>();
        for (String[] strs : equations) {
            s.add(strs[0]);
            s.add(strs[1]);
        }
        
        for (int i = 0; i < queries.length; i++){
            if(!s.contains(queries[i][0]) || !s.contains(queries[i][1])) res[i] = -1.0;
            if(queries[i][0] == queries[i][0] && s.contains(queries[i][0])) res[i] = 1.0;
            String[] keys = queries[i];
            Stack<Integer> stack = new Stack<>();
            res[i] = helper(equations, values, keys, stack);            
        }
        return res;
    }
    
    public double helper(String[][] equations, double[] values, String[] keys, Stack<Integer> stack) {
        // look up equations directly
        for (int i = 0; i < equations.length; ++i) {
            if (equations[i][0].equals(keys[0]) && equations[i][1].equals(keys[1])) return values[i];
            if (equations[i][0].equals(keys[1]) && equations[i][1].equals(keys[0])) return 1 / values[i];
        }
        
        // lookup equations by other equations
        for (int i = 0; i < equations.length; ++i) {
            if (!stack.contains(i) && keys[0].equals(equations[i][0])) {
                stack.push(i);
                double temp = values[i] * helper(equations, values, new String[]{equations[i][1], keys[1]}, stack);
                if (temp > 0) return temp;
                else stack.pop();
            }
            if (!stack.contains(i) && keys[0].equals(equations[i][1])) {
                stack.push(i);
                double temp = helper(equations, values, new String[]{equations[i][0], keys[1]}, stack) / values[i];
                if (temp > 0) return temp;
                else stack.pop();
            }
        }
        // if not find, return -1
        return -1.0;
    }
}