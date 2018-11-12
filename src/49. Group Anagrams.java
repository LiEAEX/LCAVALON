class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for(String s: strs) {
            int[] count = new int[26]; 
            for(int k = 0; k < s.length(); k++){ // i.e. if char is 'a', count[0] = count[0] + 1; 
                count[s.charAt(k)-'a']++;        // if char is 'b', count[1] = count[1] + 1
            }                                    // if char is 'c', count[2] = count[2] + 1                             
            String tempstr = Arrays.toString(count);  // "abc" = "11100***000" the amount of '0' is 23.
            if(!map.containsKey(tempstr)) {
                map.put(tempstr, i);
                if( i == res.size()) res.add(new ArrayList<>());
                i++;
            }
            res.get(map.get(tempstr)).add(s); // res.get() returns the corresponding list 
                                              // and then list.add() to add the right string to the list
        }
        return res;
    }
}