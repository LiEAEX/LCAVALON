class Solution {
    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for (int d : data){
            if (cnt == 0){
                if ((d>>5) == 0b110) cnt = 1; // 如果B的前两位为1，第三位为0，则B为两个字节表示的字符中的第一个字节, 故后面跟一个字节
                else if ((d>>4) == 0b1110) cnt=2; // 如果B的前三位为1，第四位为0，则B为三个字节表示的字符中的第一个字节, 故后面跟两个字节
                else if ((d>>3) == 0b11110) cnt=3; // 如果B的前四位为1，第五位为0，则B为四个字节表示的字符中的第一个字节, 故后面跟三个字节
                else if ((d>>7) != 0) return false; // 对于UTF-8编码中的任意字节B，如果B的第一位为0，则B独立的表示一个字符(ASCII码)
            } else {
                if ((d>>6) != 0b10) return false; // 如果B的第一位为1，第二位为0，则B为一个多字节字符中的一个字节(非ASCII字符)
                cnt--;
            }
        }
        return cnt == 0;
    }
}