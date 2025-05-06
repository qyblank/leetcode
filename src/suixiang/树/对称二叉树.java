package suixiang.树;
/*101. 对称二叉树
        简单
        相关标签
        相关企业
        给你一个二叉树的根节点 root ， 检查它是否轴对称。



        示例 1：


        输入：root = [1,2,2,3,4,4,3]
        输出：true
        示例 2：


        输入：root = [1,2,2,null,3,null,3]
        输出：false


        提示：

        树中节点数目在范围 [1, 1000] 内
        -100 <= Node.val <= 100


        进阶：你可以运用递归和迭代两种方法解决这个问题吗？

        面试中遇到过这道题?
        1/5
        是
        否
        https://leetcode.cn/problems/symmetric-tree/description/*/

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left,TreeNode right){
        //两节点为空返回true
        if(left==null&&right==null) return true;
        //一节点为空返回false
        if(left==null||right==null) return false;
        //两节点不同返回false
        if(left.val!= right.val) return false;

        //对比每一个对称节点，如果有任何一组节点不对称直接返回false
        return compare(left.left,right.right)&&compare(left.right,right.left);

    }
}
