package suixiang.链表;

import suixiang.链表.ListNode.ListNode;

import java.util.List;

/*206. 反转链表
        简单
        相关标签
        相关企业
        给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。


        示例 1：


        输入：head = [1,2,3,4,5]
        输出：[5,4,3,2,1]
        示例 2：


        输入：head = [1,2]
        输出：[2,1]
        示例 3：

        输入：head = []
        输出：[]


        提示：

        链表中节点的数目范围是 [0, 5000]
        -5000 <= Node.val <= 5000
        https://leetcode.cn/problems/reverse-linked-list/description/*/
public class 反转链表 {


    public ListNode reverseList(ListNode head) {
        //双指针,pre指向前一个节点，cur指向next将要改变的节点
        if(head==null) return null;

        ListNode pre = null;
        ListNode cur = head;

        ListNode temp = head.next;
        while (cur!=null){
            temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
