package suixiang.树;
/*124. 二叉树中的最大路径和
        困难
        相关标签
        相关企业
        二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

        路径和 是路径中各节点值的总和。

        给你一个二叉树的根节点 root ，返回其 最大路径和 。



        示例 1：


        输入：root = [1,2,3]
        输出：6
        解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
        示例 2：


        输入：root = [-10,9,20,null,null,15,7]
        输出：42
        解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42


        提示：

        树中节点数目范围是 [1, 3 * 104]
        -1000 <= Node.val <= 1000
        https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked*/
public class 二叉树中的最大路径和 {
  /*  方法一：递归
    首先，考虑实现一个简化的函数 maxGain(node)，该函数计算二叉树中的一个节点的最大贡献值，具体而言，就是在以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。

    具体而言，该函数的计算如下。

    空节点的最大贡献值等于 0。

    非空节点的最大贡献值等于节点值与其子节点中的最大贡献值之和（对于叶节点而言，最大贡献值等于节点值）。

    例如，考虑如下二叉树。

            -10
            / \
            9  20
            /  \
            15   7
    叶节点 9、15、7 的最大贡献值分别为 9、15、7。

    得到叶节点的最大贡献值之后，再计算非叶节点的最大贡献值。节点 20 的最大贡献值等于 20+max(15,7)=35，节点 −10 的最大贡献值等于 −10+max(9,35)=25。

    上述计算过程是递归的过程，因此，对根节点调用函数 maxGain，即可得到每个节点的最大贡献值。

    根据函数 maxGain 得到每个节点的最大贡献值之后，如何得到二叉树的最大路径和？对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值，如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。维护一个全局变量 maxSum 存储最大路径和，在递归过程中更新 maxSum 的值，最后得到的 maxSum 的值即为二叉树中的最大路径和。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum/solutions/297005/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return max;
    }

    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(maxSum(root.left), 0);//记录左子节点的贡献值(如果贡献值大于零)
        int right = Math.max(maxSum(root.right), 0);//记录右子节点的贡献值(如果贡献值大于零)
        if(root.val + left + right > max) max = root.val + left + right;//计算路径最大值（左节点＋node+右节点），并更新
        return root.val + Math.max(left, right);
    }

}
