package suixiang.树;
/*
114. 二叉树展开为链表
        中等
        相关标签
        相关企业
        提示
        给你二叉树的根结点 root ，请你将它展开为一个单链表：

        展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
        展开后的单链表应该与二叉树 先序遍历 顺序相同。


        示例 1：


        输入：root = [1,2,5,3,4,null,6]
        输出：[1,null,2,null,3,null,4,null,5,null,6]
        示例 2：

        输入：root = []
        输出：[]
        示例 3：

        输入：root = [0]
        输出：[0]
           https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked*/

public class 二叉树展开为链表 {
    //后序遍历，pre从最后一个数开始记录，当遍历到倒数第二个数时，将倒数第二个数的右子节点记录为pre，左子节点记录为空，pre置为当前节点
    //其它题解：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/solutions/17274/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/?envType=study-plan-v2&envId=top-100-liked
    private TreeNode pre=null;

    public void flatten(TreeNode root) {
      if(root==null) return ;

      flatten(root.right);
      flatten(root.left);
      root.right=pre;
      root.left=null;
      pre=root;

    }

}
