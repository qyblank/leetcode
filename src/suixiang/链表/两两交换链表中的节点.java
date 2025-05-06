package suixiang.链表;

import suixiang.链表.ListNode.ListNode;

import java.util.List;

/*24. 两两交换链表中的节点
        中等
        相关标签
        相关企业
        给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。



        示例 1：


        输入：head = [1,2,3,4]
        输出：[2,1,4,3]
        示例 2：

        输入：head = []
        输出：[]
        示例 3：

        输入：head = [1]
        输出：[1]


        提示：

        链表中节点的数目在范围 [0, 100] 内
        0 <= Node.val <= 100
        https://leetcode.cn/problems/swap-nodes-in-pairs/description/
        */
public class 两两交换链表中的节点 {
    //迭代法：
    // 可以通过迭代的方式实现两两交换链表中的节点。
    //
    //创建哑结点 dummyHead，令 dummyHead.next = head。令 temp 表示当前到达的节点，初始时 temp = dummyHead。每次需要交换 temp 后面的两个节点。
    //
    //如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点。
    //
    //具体而言，交换之前的节点关系是 temp -> node1 -> node2，交换之后的节点关系要变成 temp -> node2 -> node1，因此需要进行如下操作。
    //
    //temp.next = node2
    //node1.next = node2.next
    //node2.next = node1
    //完成上述操作之后，节点关系即变成 temp -> node2 -> node1。再令 temp = node1，对链表中的其余节点进行两两交换，直到全部节点都被两两交换。
    //
    //两两交换链表中的节点之后，新的链表的头节点是 dummyHead.next，返回新的链表的头节点即可。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/swap-nodes-in-pairs/solutions/444474/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-91/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public ListNode swapPairs(ListNode head) {

        if(head==null||head.next==null) return head;
        ListNode nhead =head.next;
        ListNode temp=null;
        ListNode cur=new ListNode(0);
        cur.next=head;
        while(cur.next!=null&&cur.next.next!=null){
            //保存当前节点的下一个节点，既节点2
            temp=cur.next;
            //步骤一：将当前节点1的下一个节点设置为节点3
            cur.next=cur.next.next;
            //步骤二：将节点2的下一个节点设置为节点4
            temp.next=cur.next.next;
            //步骤三：将节点3的下一个节点设置为节点2
            cur.next.next=temp;

            cur=cur.next.next;
        }

        return nhead;
    }
}
