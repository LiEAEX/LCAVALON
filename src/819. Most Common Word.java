Runtime: 16 ms, faster than 69.11% of Java online submissions for Most Common Word.
Memory Usage: 37.6 MB, less than 59.97% of Java online submissions for Most Common Word.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
}

Runtime: 16 ms, faster than 33.00% of Java online submissions for Most Common Word.
Memory Usage: 41.5 MB, less than 6.90% of Java online submissions for Most Common Word.

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> m = new HashMap<>();
        for (String temp : banned) {
            m.put(temp, -1);
        }
        
        String para = paragraph.toLowerCase();
        
        for (int i = 0; i < para.length(); i++) {
            if (!Character.isLetter(para.charAt(i))) continue;
            int endIdx = i;
            while (endIdx < para.length() && Character.isLetter(para.charAt(endIdx))) {
                endIdx++;
            }
            if ((m.containsKey(para.substring(i, endIdx)) && m.get(para.substring(i, endIdx)) != -1) || !m.containsKey(para.substring(i, endIdx))) {
                m.put(para.substring(i, endIdx), m.getOrDefault(para.substring(i, endIdx), 0) + 1);
            }
            i = endIdx;
        }
        
        int cnt = 0;
        String res = "";
        for (String temp : m.keySet()) {
            if (m.get(temp) != -1 && m.get(temp) > cnt) {
                cnt = m.get(temp);
                res = temp;
            }
        }
        
        return res;
    }
}

