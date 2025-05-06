package suixiang.栈与队列;

import java.util.LinkedList;

/*150. 逆波兰表达式求值
        中等
        相关标签
        相关企业
        给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

        请你计算该表达式。返回一个表示表达式值的整数。

        注意：

        有效的算符为 '+'、'-'、'*' 和 '/' 。
        每个操作数（运算对象）都可以是一个整数或者另一个表达式。
        两个整数之间的除法总是 向零截断 。
        表达式中不含除零运算。
        输入是一个根据逆波兰表示法表示的算术表达式。
        答案及所有中间计算结果可以用 32 位 整数表示。


        示例 1：

        输入：tokens = ["2","1","+","3","*"]
        输出：9
        解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
        示例 2：

        输入：tokens = ["4","13","5","/","+"]
        输出：6
        解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
        示例 3：

        输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        输出：22
        解释：该算式转化为常见的中缀算术表达式为：
        ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        = ((10 * (6 / (12 * -11))) + 17) + 5
        = ((10 * (6 / -132)) + 17) + 5
        = ((10 * 0) + 17) + 5
        = (0 + 17) + 5
        = 17 + 5
        = 22


        提示：

        1 <= tokens.length <= 104
        tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数*/
public class 逆波兰表达式求值 {
    //栈匹配，每遇到一个符号，取两个数字进行运算，如果是数字则直接入栈
    public int evalRPN(String[] tokens) {
        LinkedList<String> nums = new LinkedList<>();
        for (String token : tokens) {
            if (token.equals("+")) {//leetcode使用==号不能通过
                int num2 = Integer.parseInt(nums.pop());
                int num1 = Integer.parseInt(nums.pop());
                int num3 = num1 + num2;
                nums.push(String.valueOf(num3));
            } else if (token.equals("-")) {
                int num2 = Integer.parseInt(nums.pop());
                int num1 = Integer.parseInt(nums.pop());
                int num3 = num1 - num2;
                nums.push(String.valueOf(num3));
            } else if (token.equals("*")) {
                int num2 = Integer.parseInt(nums.pop());
                int num1 = Integer.parseInt(nums.pop());
                int num3 = num1 * num2;
                nums.push(String.valueOf(num3));
            } else if (token.equals("/")) {
                int num2 = Integer.parseInt(nums.pop());
                int num1 = Integer.parseInt(nums.pop());
                int num3 = num1 / num2;
                nums.push(String.valueOf(num3));
            } else {
                nums.push(token);
            }
        }
        return Integer.parseInt(nums.pop());
    }


    public static void main(String[] args) {
        逆波兰表达式求值 a = new 逆波兰表达式求值();
        String[] b={"4","13","5","/","+"};
        System.out.println(a.evalRPN(b));
    }

}
