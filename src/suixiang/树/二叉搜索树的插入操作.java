package suixiang.树;

import com.sun.source.tree.Tree;

/*701. 二叉搜索树中的插入操作
        中等
        相关标签
        相关企业
        给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

        注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。



        示例 1：


        输入：root = [4,2,7,1,3], val = 5
        输出：[4,2,7,1,3,5]
        解释：另一个满足题目要求可以通过的树是：

        示例 2：

        输入：root = [40,20,60,10,30,50,70], val = 25
        输出：[40,20,60,10,30,50,70,null,null,25]
        示例 3：

        输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
        输出：[4,2,7,1,3,5]


        提示：

        树中的节点数将在 [0, 104]的范围内。
        -108 <= Node.val <= 108
        所有值 Node.val 是 独一无二 的。
        -108 <= val <= 108
        保证 val 在原始BST中不存在。
        https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/*/
public class 二叉搜索树的插入操作 {
    //无返回值方法
    public TreeNode insertIntoBST(TreeNode root, int val) {
          TreeNode n=new TreeNode(val);
          if(root==null){
              return n;
          }
          insert(root,n);
          return root;
    }

    public void insert(TreeNode node, TreeNode n){
        int val = n.val;
        if(node.val>val) {
            if(node.left==null) {
                node.left=n;
            }else {
                insert(node.left,n);
            }
        }else {
            if(node.right==null){
                node.right=n;
            }else {
                insert(node.right,n);
            }
        }
    }

    //有返回值方法
    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null) // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
            return new TreeNode(val);

        if (root.val < val){
            root.right = insertIntoBST1(root.right, val); // 递归创建右子树
        }else if (root.val > val){
            root.left = insertIntoBST1(root.left, val); // 递归创建左子树
        }
        return root;
    }
}
