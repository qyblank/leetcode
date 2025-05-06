package suixiang.链表;

import suixiang.链表.ListNode.ListNode;

import java.util.LinkedList;

/*19. 删除链表的倒数第 N 个结点
        中等
        相关标签
        相关企业
        提示
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。



        示例 1：


        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：

        输入：head = [1], n = 1
        输出：[]
        示例 3：

        输入：head = [1,2], n = 1
        输出：[1]


        提示：

        链表中结点的数目为 sz
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
        https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/*/
public class 删除链表的倒数第n个节点 {

    //方法二：栈
    //
    //我们也可以在遍历链表的同时将所有节点依次入栈。根据栈「先进后出」的原则，
    // 我们弹出栈的第 n 个节点就是需要删除的节点，并且目前栈顶的节点就是待删除节点的前驱节点。
    // 这样一来，删除操作就变得十分方便了。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solutions/450350/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //使用虚假头节点，这样就不用特殊处理第一个节点
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        LinkedList<ListNode> listNodes = new LinkedList<>();
        ListNode p= dummy;

        while(p!=null){
            listNodes.push(p);
            p=p.next;
        }

        for (int i = 0; i !=n;i++) p=listNodes.pop();

        p=listNodes.peek();
        p.next=p.next.next;
        //新头节点为虚假头节点的下一个节点
        return dummy.next;
    }


}
