sliding window

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() < 1) return 0;
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        int l = 0, r = 0, res = 0;

        while(r < s.length()) {
            if(m.size() <= k) { 
                char c = s.charAt(r);  
                m.put(c, r); 
                r++;
            }
            if(m.size() > k) { 
                int temp = s.length();
                for(int i : m.values()) { 
                    temp = Math.min(temp, i);
                }
                char c = s.charAt(temp);
                m.remove(c); 
                l = temp + 1;
            }
            res = Math.max(res, r - l);
        }
        return res;
    }
}