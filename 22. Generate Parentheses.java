class Solution {
    public List<String> generateParenthesis(int n) {
      List<String> res = new ArrayList<String>();
      helper(n, n, "", res);
      return res;  
    }
    
    void helper(int left, int right, String out, List<String> res) {
        if (left < 0 || right < 0 || left > right) return;
        //左小于等于右保证不会出现")("等类似情况
        
        if (left == 0 && right == 0) {
            res.add(out);
            return;//不带返回值的return语句只能用于返回类型为void的函数
        }
        helper(left - 1, right, out + "(", res);
        helper(left, right - 1, out + ")", res);
    }
}