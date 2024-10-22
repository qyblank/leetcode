package code;

public class ZshapedTransformation {

    public static void main(String[] args) {
        String s="PAYPALISHIRING";
        System.out.println(convert(s,3));
    }
    static String convert(String s, int numRows) {
        String rs=new String();

        int n=numRows-1;
        if(n==0) return s;
        //
        for (int i = 0; i <= n; i++) {//对每一行进行循环

            for (int j = 0; ; j+=2*n) {//对每一列进行循环
                //System.out.println(j-i);
                if(j-i>=s.length()) break;//超出字符串s长度则跳到下一行

                if(i==0||i==n){//第一行和最后一行的情况
                    //System.out.println(i+j);
                    if(j+i<s.length())rs+=s.charAt(i+j);
                }else {//中间行情况
                    if(j-i>=0) rs+=s.charAt(j-i);
                   if(j+i<s.length()) rs+=s.charAt(j+i);
                }
            }
        }

        return rs;
    }
}
