class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        HashSet<Integer> reach = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // Map中每个站点与经过该站点的BUS线路对应（一对多）
        int res = 0;
        
        if (S == T) return 0;
        
        for(int i = 0; i < routes.length; i++){  // i对应线路编号
            for(int j = 0; j < routes[i].length; j++){ // j对应每条线路里的站点编号
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);                
            }       
        }
        
        q.offer(S); 
        while (!q.isEmpty()) {
            int len = q.size();
            res++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for (int bus: buses) {
                     if (reach.contains(bus)) continue;
                     reach.add(bus);
                     for (int j = 0; j < routes[bus].length; j++) {
                         if (routes[bus][j] == T) return res;
                         q.offer(routes[bus][j]);  
                    }
                }
            }
        }
        return -1;        
    }
}