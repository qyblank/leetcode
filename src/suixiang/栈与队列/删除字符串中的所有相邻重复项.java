package suixiang.栈与队列;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/* 1047. 删除字符串中的所有相邻重复项
    力扣题目链接(opens new window)

    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

    在 S 上反复执行重复项删除操作，直到无法继续删除。

    在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

    示例：

    输入："abbaca"
    输出："ca"
    解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
    之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
    提示：

            1 <= S.length <= 20000
    S 仅由小写英文字母组成。*/
public class 删除字符串中的所有相邻重复项 {

    //使用栈思想进行匹配，遇到相同字母进行出栈
    //linkedlist双向链表，既有list操作又有栈操作
    //add方法是尾插法，push方法是头插法
    //pop方法返回并删除头节点
    //使用add搭配peeklast，可实现栈功能同时保持插入顺序
    public String removeDuplicates(String s) {

        LinkedList<Character> c = new LinkedList<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if(!c.isEmpty()&&chars[i]==c.peekLast()) {//非空判断防止空指针异常，同时处理空字符串情况
                c.removeLast();
                continue;
            }
            c.add(chars[i]);
        }
        String ns="";
        for (Character character : c) {
            ns+=character;
        }

        return ns;
    }
}
