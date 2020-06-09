

Runtime: 12 ms, faster than 61.93% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 44.8 MB, less than 27.52% of Java online submissions for Find All Anagrams in a String.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> occurences = new ArrayList<>();
        if (s.isEmpty() || p.length() >= s.length()) return occurences;
        int n = s.length(), m = p.length();
        int[] textHash = new int[26];
        int[] patternHash = new int[26];
        for (int i = 0; i < m; i++) {
            textHash[s.charAt(i) - 'a']++;
            patternHash[p.charAt(i) - 'a']++;
        }
        for (int i = m; i < n; i++) {
            if (Arrays.equals(textHash, patternHash)) occurences.add(i-m);
            textHash[s.charAt(i-m) - 'a']--;
            textHash[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(textHash, patternHash)) occurences.add(n-m);
        return occurences;
    }
}


Runtime: 1467 ms, faster than 9.50% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 114.2 MB, less than 5.00% of Java online submissions for Find All Anagrams in a String.

Runtime: 1167 ms, faster than 12.12% of Java online submissions for Find All Anagrams in a String.
Memory Usage: 41.4 MB, less than 38.11% of Java online submissions for Find All Anagrams in a String.   if change 256 to 26, while changing arr[s.charAt(j)] to arr[s.charAt(j) - 'a'] at the same time

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s == null || s.length() < p.length()) return res;
        boolean[] record = new boolean[s.length() - p.length() + 1];
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (i >= 1 && record[i - 1] && s.charAt(i - 1) == s.charAt(i + p.length() - 1)) {
                record[i] = true;
                res.add(i);
                continue;
            }
            record[i] = anagramHelper(i, s, p);
            if (record[i]) res.add(i);
        }
        return res;
    }
    
    public boolean anagramHelper(int idx, String s, String p) {
        int[] arr = new int[256];
        for (int j = idx; j < idx + p.length(); j++) {
            arr[s.charAt(j)]++;
            arr[p.charAt(j - idx)]--;
        }
        
        for (int j = idx; j < idx + p.length(); j++) {
            if (arr[s.charAt(j)] != 0) return false;
        }
        
        return true;        
    }
}