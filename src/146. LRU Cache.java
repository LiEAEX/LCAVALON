class LRUCache {
    int size = 0, capacity;    
    Map<Integer, Integer> cache = new LinkedHashMap<Integer, Integer>();
    public LRUCache(int capacity) { // LinkedHashMap具有HashMap特性的同时记录插入元素的先后顺序
       this.capacity = capacity; 
    }
    
    public int get(int key) {
        int ans = -1;
        if(cache.containsKey(key)) {
            ans = cache.get(key);
            cache.remove(key); // remove and add the key again whenever it is used to update
            cache.put(key, ans); // add the key
        }      
        return ans; 
    }
    
    public void put(int key, int value) {
        Set<Integer> set = cache.keySet(); // keySet()获取map里全部的key值
        int first;
        if(cache.containsKey(key)) {
            cache.remove(key); //必须有remove，此处put是在LinkedHashMap的原位置进行覆盖
            cache.put(key, value); //故先移除再加入保持更新，这样才保证优先移除旧的
            return; //直接置换成新的，size不变，执行完后跳出put函数
        }
        for(int i: set) {
            first = i;
            if(size == capacity) {
                cache.remove(first);
                size--;
            }
            break;
        }        
        size++;
        cache.put(key, value);
    }
}
//The idea is to remove and add the key again whenever it is used (get or updated). The first key is the most old key so whenever map size meets the capacity, remove first element.

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */