package code;/*12. 整数转罗马数字
        中等
        相关标签
        相关企业
        七个不同的符号代表罗马数字，其值如下：

        符号	值
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000
        罗马数字是通过添加从最高到最低的小数位值的转换而形成的。将小数位值转换为罗马数字有以下规则：

        如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
        如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
        只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
        给定一个整数，将其转换为罗马数字。



        示例 1：

        输入：num = 3749

        输出： "MMMDCCXLIX"

        解释：

        3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
        700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
        40 = XL 由于 50 (L) 减 10 (X)
        9 = IX 由于 10 (X) 减 1 (I)
        注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
        示例 2：

        输入：num = 58

        输出："LVIII"

        解释：

        50 = L
        8 = VIII
        示例 3：

        输入：num = 1994

        输出："MCMXCIV"

        解释：

        1000 = M
        900 = CM
        90 = XC
        4 = IV


        提示：

        1 <= num <= 3999*/


import java.util.ArrayList;
import java.util.List;

/*             I	1
               V	5
               X	10
               L	50
               C	100
               D	500
               M	1000*/
public class 罗马数字转换为整数 {
    public String intToRoman(int num) {
        String str="";

        int t=num;
        List<Integer> l=new ArrayList<>();
        //将num分解，123分解为100+20+3
        for (int i = 10;t>0 ; i*=10) {
            l.add(t%i);
            t-=t%i;
        }

        for (Integer j=l.size()-1,integer=l.get(j);j>=0;j--) {
            integer=l.get(j);
            if(integer>=1000){
                for (int i = 0; i < integer/1000; i++) {
                    str+="M";
                }
            }

            if(integer<1000&&integer>=500){
                if(integer==900){
                    str+="CM";
                }
                else {
                    str += "D";
                    for (int i = 0; i < (integer - 500) / 100; i++) {
                        str += "C";
                    }
                }
            }

            if(integer<500&&integer>=100){
                if(integer==400){
                    str+="CD";
                }else{
                    for (int i = 0; i < integer/100; i++) {
                        str+="C";
                    }
                }
            }


            if(integer<100&&integer>=50){
                if(integer==90){
                    str+="XC";
                }
                else {
                    str += "L";
                    for (int i = 0; i < (integer - 50) / 10; i++) {
                        str += "X";
                    }
                }
            }

            if(integer<50&&integer>=10){
                if(integer==40){
                    str+="XL";
                }else{
                    for (int i = 0; i < integer/10; i++) {
                        str+="X";
                    }
                }
            }


            if(integer<10&&integer>=5){
                if(integer==9){
                    str+="IX";
                }
                else {
                    str += "V";
                    for (int i = 0; i < (integer - 5); i++) {
                        str += "I";
                    }
                }
            }

            if(integer<5&&integer>=1){
                if(integer==4){
                    str+="IV";
                }else{
                    for (int i = 0; i < integer; i++) {
                        str+="I";
                    }
                }
            }
        }
        return str;
    }
}
