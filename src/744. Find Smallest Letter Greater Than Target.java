class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        for (char c : letters){
            if (c <= target) continue;
            res = c;
            break;
        }
        return res;
    }
}


// 二分
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h){
            int m = l + (h - l) / 2;  // if h and l are all big integers, l+h will cause integer overflow. 
                                      // so use l + (h - l) / 2 instead of (h + l) / 2
            if (letters[m] <= target){
                l = m + 1;
            }
            else {
                h = m - 1;
            }
        }
        return l <= letters.length - 1? letters[l]:letters[0];
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l < h){
            int m = l + (h - l) / 2;
            if (letters[m] <= target){
                l = m + 1;
            }
            else {
                h = m;
            }
        }
        return letters[l] > target? letters[l]:letters[0];
    }
}
