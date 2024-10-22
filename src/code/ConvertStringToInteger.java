package code;

//字符串转换为整数


public class ConvertStringToInteger {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;//字符串为空直接返回零

        int num=0,i=0;
        for (; i < s.length(); i++) {//处理无用前导空格
            if(s.charAt(i)!=' ') break;
        }

        if(s.length()==i) return 0;

          int flag1=0,flag2=0;
          if(s.charAt(i)=='-') flag1=1;//标记num为负数
        if(s.charAt(i)=='+') flag1=2;//标记num为正数
       if(flag1!=0) i++;
        if(s.length()==i) return 0;
        for (; i < s.length(); i++) {

            if(s.charAt(i)=='0'&&num==0) continue;//处理前置零
            if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
                num=num*10+s.charAt(i)-'0';
            }else break;

            if(num==214748364&&(i<s.length()-1)&&(s.charAt(i+1)>'7')) {
                flag2=1;
                break;
            }
            if(num>214748364&&(i<s.length()-1)&&(s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')) {
                flag2=1;
                break;
            }
        }

        if(flag1==1){
            if(flag2==1) return -2147483648;//num为负数且过大情况
            return -num;
        }else {
            if(flag2==1) return 2147483647;
            return num;
        }
    }
}
