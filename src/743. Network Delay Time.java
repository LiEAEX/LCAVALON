"Djikstra's Algorithm"
求单个点到所有点最短路径的最大值
"https://stackoverflow.com/questions/11003155/change-priorityqueue-to-max-priorityqueue"

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times){
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        
        //distance, node into pq
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        // when input array a and b, output a[0]-b[0], "->" is lambda signal
        // (a,b) -> (a[0] - b[0]): PriorityQueue会按照数组第一个数大小的从小到大排列（Djikstra）
        
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N+1];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curNode = cur[1]; // initial K
            int curDist = cur[0]; // initial 0
            if(visited[curNode]) continue;
            visited[curNode] = true;
            res = curDist;
            N--;
            if(map.containsKey(curNode)){
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? res : -1;
    }
}