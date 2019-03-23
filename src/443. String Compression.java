class Solution {
    public int compress(char[] chars) {
        int i = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[i] = currentChar;
            i++;
            if(count != 1){
                for(char c : String.valueOf(count).toCharArray()){//int转string后再转charArray
                    chars[i] = c;
                    i++;
                }
            }
        }
        return i;
    }
}


class Solution {
    public int compress(char[] chars) {
        int i = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[i] = currentChar;
            i++;
            if(count != 1){
                for(char c : Integer.toString(count).toCharArray()){//int转string后再转charArray
                    chars[i] = c;
                    i++;
                }
            }
        }
        return i;
    }
}