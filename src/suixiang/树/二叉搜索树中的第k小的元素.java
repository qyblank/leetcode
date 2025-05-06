package suixiang.树;

import com.sun.source.tree.Tree;

public class 二叉搜索树中的第k小的元素 {
    int num=0;
    int t=0;
    public int kthSmallest(TreeNode root, int k) {
             searchk(root,k);
             return t;
    }

    public void searchk(TreeNode node,int k){
        if(node==null) return;

        searchk(node.left,k);
        num++;
        if(k==num){
            t=node.val;
            return ;
        }
        searchk(node.right,k);
    }
}
