Runtime: 98 ms, faster than 17.57% of Java online submissions for Task Scheduler.
Memory Usage: 40.3 MB, less than 28.92% of Java online submissions for Task Scheduler.


class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        HashMap<Character, Integer> m = new HashMap<>();
        for (char c : tasks){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        Queue<Integer> q = new PriorityQueue<>((l1,l2) -> l2 - l1);
        for (char c : m.keySet()){
            q.offer(m.get(c));
        }
        
        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while (!q.isEmpty() || !coolDown.isEmpty()) {
            if (coolDown.containsKey(currTime - n - 1)) {
                q.offer(coolDown.remove(currTime - n - 1));
            }
            if (!q.isEmpty()) {
                int left = q.poll() - 1;
        	    if (left != 0) coolDown.put(currTime, left);
            }
            currTime++;
        }
        
        return currTime;
    }
}