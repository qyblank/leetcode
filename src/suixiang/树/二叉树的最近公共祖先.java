package suixiang.树;
/*236. 二叉树的最近公共祖先
        中等
        相关标签
        相关企业
        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



        示例 1：


        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出：3
        解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
        示例 2：


        输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出：5
        解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
        示例 3：

        输入：root = [1,2], p = 1, q = 2
        输出：1


        提示：

        树中节点数目在范围 [2, 105] 内。
        -109 <= Node.val <= 109
        所有 Node.val 互不相同 。
        p != q
        p 和 q 均存在于给定的二叉树中。*/
public class 二叉树的最近公共祖先 {
/*    遇到这个题目首先想的是要是能自底向上查找就好了，这样就可以找到公共祖先了。

    那么二叉树如何可以自底向上查找呢？

    回溯啊，二叉树回溯的过程就是从底到上。

    后序遍历（左右中）就是天然的回溯过程，可以根据左右子树的返回值，来处理中节点的逻辑。

    接下来就看如何判断一个节点是节点q和节点p的公共祖先呢。

    首先最容易想到的一个情况：如果找到一个节点，发现左子树出现结点p，右子树出现节点q，或者 左子树出现结点q，
    右子树出现节点p，那么该节点就是节点p和q的最近公共祖先。*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);

    }

    //后序遍历,回溯查找
    //递归返回值为节点
    public TreeNode find(TreeNode node,int p,int q){
        //递归结束条件：
        //1.该节点为空
        //2.该节点为需要找的节点之一
        if(node==null) return null;
        if(node.val==p||node.val==q) return node;
        //单层递归逻辑
        //查找左右两节点中是否存在p，q或者最近公共祖先
        TreeNode left=find(node.left,p,q);
        TreeNode right=find(node.right,p,q);

        //如果左右节点查找结果均不为空，则该节点必为最近公共节点
        if(left!=null&&right!=null) return node;
        ////如果左右节点由返回值那么说明要么返回值时q，p
        //或者返回值就是最近公共节点
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
}
