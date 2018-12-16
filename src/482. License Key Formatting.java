class Solution {
    public String licenseKeyFormatting(String S, int K) {
        // Replacing all "-" and converting all letters to uppercase
        String S1 = S.replace("-","");
        S1 = S1.toUpperCase();
        
        StringBuffer sb = new StringBuffer(S1);
        /*for(int i = 0; i < S1.length(); i++) {
            sb.append(S1.charAt(i));
        }*/
        
        //int total = sb.toString().length();
        int total = S1.length();
        // Inserting '-' from back at every K position
        for (int i = K; i < total; i = i + K) {
            sb.insert(total - i,'-');
        }
        return sb.toString();
    }
}