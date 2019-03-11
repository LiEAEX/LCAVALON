Runtime: 1 ms, faster than 89.66% of Java online submissions for Compare Version Numbers.
Memory Usage: 33 MB, less than 93.21% of Java online submissions for Compare Version Numbers.

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int m = a.length, n = b.length, res = 0;
        if (m >= n){
            res = compareHelper(a, b, m, n);
        }
        else if (m < n){
            res = -1 * compareHelper(b, a, n, m);
        }
        
        return res;
    }
    
    private int compareHelper(String[] a, String[] b, int m, int n){
        int tp = 0;
        for (int i = 0; i < n; i++){
            a[i] = prune(a[i]);
            b[i] = prune(b[i]);
            if (Integer.parseInt(a[i]) > Integer.parseInt(b[i])){
                tp = 1;
                break;
            }
            else if (Integer.parseInt(a[i]) < Integer.parseInt(b[i])){
                tp = -1;
                break;
            }            
        }
        if (tp == 0){
           for(int i = n; i < m; i++){
               a[i] = prune(a[i]);
               if (!a[i].equals("0")){
                   tp = 1;
                   break;
               }
           } 
        }       
        return tp;
    }
    
    private String prune(String str){
        if (str.length() == 1) return str;
        int start = 0;
        for (int j = 0; j < str.length(); j++){
            if (str.charAt(j) == '0' && j < str.length() - 1) continue;
            start = j;
            break;
        }
        
        return str.substring(start);
    }
}