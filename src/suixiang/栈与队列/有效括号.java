package suixiang.栈与队列;

import java.util.LinkedList;

/*20. 有效的括号
        简单
        相关标签
        相关企业
        提示
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        每个右括号都有一个对应的相同类型的左括号。


        示例 1：

        输入：s = "()"

        输出：true

        示例 2：

        输入：s = "()[]{}"

        输出：true

        示例 3：

        输入：s = "(]"

        输出：false

        示例 4：

        输入：s = "([])"

        输出：true



        提示：

        1 <= s.length <= 104
        s 仅由括号 '()[]{}' 组成*/
public class 有效括号 {
    //匹配问题，使用栈，每次入栈一个右括号，必须有一个相应的左括号匹配
    public boolean isValid(String s) {
        LinkedList<Character> c = new LinkedList<>();
        if (s.length() % 2 == 1) return false;//不是二的倍数直接返回false

        for (int i = 0; i < s.length(); i++) {
            Character a=s.charAt(i);

            if(a==')'){
                //对右括号进行匹配左括号
                // c.isEmpty()匹配右括号多余情况
                if(c.isEmpty()||c.pop()!='(') return false;
            }else if(a==']'){
                if(c.isEmpty()||c.pop()!='[') return false;
            }else if(a=='}'){
                if(c.isEmpty()||c.pop()!='{') return false;
            }else {
                c.push(a);
            }
        }
        if(c.isEmpty()) return true;//栈非空为左括号多余或着有非括号字符
        return false;
    }
}
