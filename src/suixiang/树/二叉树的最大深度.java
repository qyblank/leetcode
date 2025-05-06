package suixiang.树;

public class 二叉树的最大深度 {

    public int maxDepth(TreeNode root) {
          return depth(root);
    }

    public int depth(TreeNode node){
        if(node==null) return 0;
        //节点不为空计数加一，返回左右节点中的最大值
        return Math.max(1+depth(node.left),1+depth(node.right));
    }

}
