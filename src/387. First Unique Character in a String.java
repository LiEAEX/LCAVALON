import java.util.HashMap;
class Solution {
    public int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        
        for(int i = 0; i < c.length; i++){
            m.put(c[i], m.getOrDefault(c[i], 0) + 1);
        }
        
        for(int i = 0; i < c.length; i++){
            if(m.get(c[i]) == 1) return i;
        }
        
        return -1;
    }
}