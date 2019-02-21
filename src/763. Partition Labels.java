class Solution {
    public List<Integer> partitionLabels(String S) {
        // edge case
        if(S == null || S.length() == 0){
            return null;
        }
        
        List<Integer> res = new ArrayList<>();        
        // record the last index of the each char
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i = 0; i < S.length(); i++){
            m.put(S.charAt(i), i);
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, m.get(S.charAt(i)));
            if(last == i){
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}