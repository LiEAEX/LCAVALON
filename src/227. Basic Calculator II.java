class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        String st = s.replaceAll(" ", "");
        
        char preSign = '+';
        int preNum = 0;
        int res = 0;
        int start = 0;
        int num = 0;
        
        for (int i = 0; i < st.length(); i++){
            if (Character.isDigit(st.charAt(i)) && i < st.length()-1) continue;
            if (i == st.length()-1) {
                num = Integer.valueOf(st.substring(start));
            } else {
                num = Integer.valueOf(st.substring(start, i));
                start = i + 1;
            }
            
            if (preSign == '*'){
                preNum *= num; // not update res, but combine with preNum
            } 
            else if (preSign == '/'){
                preNum /= num; // not update res, but combine with preNum
            }
            else if (preSign == '+'){
                res += preNum; // update res and preNum
                preNum = num;
            }
            else if (preSign == '-'){
                res += preNum ; // update res and preNum
                preNum = -1 * num;
            }
            
            preSign = st.charAt(i);
        }
        
        res += preNum; // add the last number to res      
        return res;
    }
}