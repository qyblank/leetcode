package suixiang.链表;


import suixiang.链表.ListNode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class 移除链表元素 {




    public ListNode removeElements(ListNode head, int val) {
        //设置一个虚拟头结点，这样原链表的所有节点就都可以按照统一的方式进行移除了。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy;
        while(p.next != null) {
            if(p.next.val == val) {
                p.next = p.next.next;
            }else{
                p = p.next;
            }
        }

        return dummy.next;
    }
}