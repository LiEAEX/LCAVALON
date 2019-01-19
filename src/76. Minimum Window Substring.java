1 create a hashmap for each character in t and count their frequency in t as the value of hashmap.
2 Find the first window in S that contains T. But how? there the author uses the count.
3 Checking from the leftmost index of the window and to see if it belongs to t. The reason we do so is that we want to shrink the size of the window.
   3-1) If the character at leftmost index does not belong to t, we can directly remove this leftmost value and update our window(its minLeft and minLen value)
   3-2) If the character indeed exists in t, we still remove it, but in the next step, we will increase the right pointer and expect the removed character. 
        If find so, repeat step 3.

"Sliding window"


class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) return ""; // corner case
        
        HashMap<Character, Integer> map = new HashMap<>();
        /*for (char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
            map.put(c,1);
            }
        }*/
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1); // record the letter and the times it appears
                
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0; // count means the total characters we have matched in String t
        for (int right = 0; right < s.length(); right++){
            // get the first window that contains whole t
            if(map.containsKey(s.charAt(right))){ 
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0){
                    count++;
                }
                while (count == t.length()){// the count is equal to length of t, then we find the window
                    if (right - left + 1 < minLen){
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))){//starting from the leftmost index of the window, we want to check if s[left] is in t. 
                                                        //If so, we will remove it from the window, and increase 1 time on its counter in hashmap 
                                                        //which means we will expect the same character later by shifting right index. 
                                                        //At the same time, we need to reduce the size of the window due to the removal.
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0){
                            count--;
                        }
                    }
                    left++; //if it doesn't exist in t, it is not supposed to be in the window, left++. 
                            //If it does exist in t, the reason is stated as above. left++.
                }
            }
        }
        
        if (minLen > s.length()) return "";           
        return s.substring(minLeft, minLeft + minLen);            
    }

}