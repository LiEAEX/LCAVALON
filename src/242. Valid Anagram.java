Runtime: 17 ms

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : a){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        for (char d : b){
            if (!m.containsKey(d)) return false;
            m.put(d, m.get(d) - 1);
        }
        for (int e : m.values()){
            if (e != 0) return false;
        }
        return true;
    }
}


Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Anagram.
Memory Usage: 27.8 MB, less than 22.18% of Java online submissions for Valid Anagram.
Below much more faster, use array only

class Solution {
    public boolean isAnagram(String s, String t) {
    
    int[] charsMap = new int['z'-'a'+1];
    
    for(char c: s.toCharArray()) {
        int pos = c - 'a';
        charsMap[pos]++;
    }
    
    for(char c: t.toCharArray()) {
        int pos = c - 'a';
        charsMap[pos]--;
    }
    
    for(int count: charsMap) {
        if(count != 0) {
            return false;
        }
    }
    
    return true;
}
}