package suixiang.树;
/*98. 验证二叉搜索树
        中等
        相关标签
        相关企业
        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

        有效 二叉搜索树定义如下：

        节点的左子树只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。


        示例 1：


        输入：root = [2,1,3]
        输出：true
        示例 2：


        输入：root = [5,1,4,null,null,3,6]
        输出：false
        解释：根节点的值是 5 ，但是右子节点的值是 4 。


        提示：

        树中节点数目范围在[1, 104] 内
        -231 <= Node.val <= 231 - 1
        https://leetcode.cn/problems/validate-binary-search-tree/description/*/

public class 验证二叉搜索树 {
   /* 中序遍历下，输出的二叉搜索树节点的数值是有序序列。

    有了这个特性，验证二叉搜索树，就相当于变成了判断一个序列是不是递增的了。*/
    long last=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return search(root);
    }

    public boolean search(TreeNode node){
        //通过中序遍历验证每一个遍历到的值是否大于上一个值，以此判断是否有序
        if(node==null) return true;

        boolean b1=search(node.left);
        if(node.val<=last) return false;
        last=node.val;
        boolean b2=search(node.right);

        return b1&&b2;
    }
}
