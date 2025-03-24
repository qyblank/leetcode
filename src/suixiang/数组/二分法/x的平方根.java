package suixiang.数组.二分法;
/*69. x 的平方根
        简单
        相关标签
        相关企业
        提示
        给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

        由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
        https://leetcode.cn/problems/sqrtx/description/*/
public class x的平方根 {
    public int mySqrt(int x) {
        //二分法查找第一个平方小于x的数
        //关键点：
        //1.特殊值的平方根如1，0
        //2.int值最大为2147395599，平方根为46340，mid超过这个值直接判断为平方大于x，不然有溢出风险
        //3.边界问题：该题左右边界是不可排除边界，在每次比较之后，left或right之只能变动为mid

        if(x==1) return 1;
        if(x==0) return 0;
        int left=1;
        int right=x;
        int mid=x/2;
        while (left<right-1){
            //System.out.println("------------");
            // System.out.println(mid);
            int sq=mid*mid;
            // System.out.println(sq);
            if(sq==x) return mid;
            if(sq>x||mid>46340){
                right=mid;
                mid=left+(right-left)/2;
            }else{
                left=mid;
                mid=left+(right-left)/2;
            }
        }
        return mid;
    }
}
