class Solution {
    public String nextClosestTime(String time) {

       StringBuilder t = new StringBuilder(time.replace(":",""));
        // Get unique digits
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            s.add(t.charAt(i));
        }
        // Sort them
        List<Character> digits = new ArrayList<>(s);
        Collections.sort(digits);
        // Create digit to index map for O(1) lookup
        Map<Character,Integer> m = new HashMap<>();
        for(int i = 0; i < digits.size(); i++) {
            m.put(digits.get(i), i);
        }
        // For each digit, right to left
        for(int j = 3; j >= 0; j--) {
            char val = t.charAt(j);
            int index = m.get(val);
            // If there is a larger value available, try it
            if(index < digits.size() - 1) {
                index++;
                t.setCharAt(j, digits.get(index));
                if(((t.charAt(0) <= '2' && t.charAt(1) <= '3') || (t.charAt(0) <= '1' && time.charAt(1) <= '9')) && t.charAt(2) <= '5') break; // valid time
                // 使用break而不是continue，这里需要变动时间最小，故如果改动之后为有效时间就可以直接输出结果了，不能再改别的
                t.setCharAt(j, val); // 说明改动后的时间不是valid time，故还原为改动之前的值
            }
            // Otherwise, replace with smallest value and move to next digit
            t.setCharAt(j, digits.get(0));
        }
        t.insert(2, ':');
        return t.toString();
    }
    
}