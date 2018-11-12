class Solution {
    public String convert(String s, int numRows) {
      //主要利用字符串的拼接 +
        int len=s.length();
        if(len==0 || len==1 || numRows==1) return s;
        String[] ans=new String[numRows];
        //给字符串赋值
        Arrays.fill(ans, "");
        int row=0, a=1;//a的正负改变row的方向
        for(int i=0;i<len;i++){
            ans[row]+=s.charAt(i);
            row+=a;
            if(row>=numRows){
                row=row-2;
                a=-1;
            }
            if(row<0){
                row=1;
                a=1;
            }
        }
        //将 ans 的每一行拼接起来
        String str=new String();
        for(int j=0;j<numRows;j++){
            str+=ans[j];
        }
        return str;
    }
}