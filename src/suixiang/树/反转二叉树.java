package suixiang.树;

import java.util.Deque;
import java.util.LinkedList;

/*226. 翻转二叉树
        简单
        相关标签
        相关企业
        给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。



        示例 1：



        输入：root = [4,2,7,1,3,6,9]
        输出：[4,7,2,9,6,3,1]
        示例 2：



        输入：root = [2,1,3]
        输出：[2,3,1]
        示例 3：

        输入：root = []
        输出：[]
        https://leetcode.cn/problems/invert-binary-tree/description/*/
public class 反转二叉树 {
    //层序遍历翻转
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        Deque<TreeNode> deque =new LinkedList<>();
        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode t=new TreeNode();
            TreeNode poll = deque.poll();
            if(poll.left!=null) deque.add(poll.left);
            if(poll.right!=null) deque.add(poll.right);
            t=poll.left;
            poll.left=poll.right;
            poll.right=t;
        }
        return root;
    }

}
