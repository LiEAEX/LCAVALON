// Solution using BFS
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int max_len = -1;
        for (String word : wordDict){
            max_len = Math.max (max_len, word.length ()); 
        }
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int start = queue.remove();
            for (int end = start + 1; end <= s.length () && end - start <= max_len; end++) {
                if (wordDictSet.contains(s.substring(start, end)) && !(end < s.length () && visited[end])) {
                    if (end == s.length()) {
                        return true;
                    }
                    queue.add(end);
                    visited[end] = true;
                }
            }
        }
        return false;
    }
}