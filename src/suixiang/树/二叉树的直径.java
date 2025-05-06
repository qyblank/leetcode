package suixiang.树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/*543. 二叉树的直径
        简单
        相关标签
        相关企业
        给你一棵二叉树的根节点，返回该树的 直径 。

        二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。

        两节点之间路径的 长度 由它们之间边数表示。



        示例 1：


        输入：root = [1,2,3,4,5]
        输出：3
        解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
        示例 2：

        输入：root = [1,2]
        输出：1


        提示：

        树中节点数目在范围 [1, 104] 内
        -100 <= Node.val <= 100
        https://leetcode.cn/problems/diameter-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked*/
public class 二叉树的直径 {
    //二叉树的直径：二叉树中任意两个节点之间的路径长度中的最大值，这里的路径长度指的是两个节点之间边的数量。

    //最长路径经过的节点数
    int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
         ans=1;
         depth(root);
         return ans-1;
    }
    public int depth(TreeNode node){
        if(node==null) return 0;

        int l=depth(node.left);//左子树的最大深度
        int r=depth(node.right);//右子树的最大深度

        ans=Math.max(l+r+1,ans);//当前节点的最大直径
        return Math.max(l,r)+1;//当前节点的最大深度
    }
}
