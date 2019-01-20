class Solution {
    public boolean backspaceCompare(String S, String T) {
       return getString(S).equals(getString(T));
    }
    
    private String getString(String str) {
        int n = str.length(), count = 0;
        String result = "";
        for (int i = n - 1; i >= 0; i--){
            char c = str.charAt(i);
            if (c=='#') 
                count++;
            else {
                if(count > 0)
                    count--;
                else {
                    result += c;
                }                     
            }
        }
        return result;
    }
}