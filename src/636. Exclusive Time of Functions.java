class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTS = 0;
        String cur = "";
        for (String str : logs){            
            String[] s = str.split(":");

            if (s[1].equals("start")){// 用stack确保前面有未结束的进程时遇到start才计数
                if (!stack.isEmpty()){
                    res[stack.peek()] += Integer.valueOf(s[2]) - prevTS;
                }
                stack.push(Integer.valueOf(s[0]));
                prevTS = Integer.valueOf(s[2]);
            } 
            else if (s[1].equals("end")){
                res[stack.pop()] += Integer.valueOf(s[2]) - prevTS + 1;
                prevTS = Integer.valueOf(s[2]) + 1;
            }
        }
        return res;
    }
}