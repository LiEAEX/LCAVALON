The List is used to store numbers and serve the getRandom() method. The Map contains the mapping between the value and its index in the ArrayList. 
The Map helps to check whether a value is already inserted or not. The main trick is when you remove a value. 
"ArrayList's remove method is O(n) if you remove from random location. "
To overcome that, we swap the values between (randomIndex, lastIndex) and always remove the entry from the end of the list. 
After the swap, you need to update the new index of the swapped value (which was previously at the end of the list) in the map.

Runtime: 71 ms, faster than 70.49% of Java online submissions for Insert Delete GetRandom O(1).
Memory Usage: 36.2 MB, less than 34.73% of Java online submissions for Insert Delete GetRandom O(1).

class RandomizedSet {

    HashMap<Integer, Integer> valToInd;
    List<Integer> list;
    int ind = 0;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToInd = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToInd.containsKey(val)) return false;
        list.add(val);
        valToInd.put(val,list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = valToInd.getOrDefault(val,-1);
        if(ind == -1) return false;
        Collections.swap(list,ind,list.size()-1);
        int swappedWith = list.get(ind);
        valToInd.put(swappedWith,ind);
        list.remove(list.size()-1);
        valToInd.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int max = list.size();
        int min = 0;
        int ind = (int)(Math.random() * (max - min) + min);
        return list.get(ind);
    }
}


Runtime: 471 ms, faster than 0.99% of Java online submissions for Insert Delete GetRandom O(1).
Memory Usage: 51.4 MB, less than 0.92% of Java online submissions for Insert Delete GetRandom O(1).

import java.util.Random;

class RandomizedSet {

    HashSet<Integer> s = new HashSet<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        //HashSet<Integer> s = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (s.contains(val)) return false;
        s.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!s.contains(val)) return false;
        s.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //if (s.size() == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (int e : s){
            list.add(e);
        }
        int n = list.size();
        Random r = new Random();
        return list.get(r.nextInt(n));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */