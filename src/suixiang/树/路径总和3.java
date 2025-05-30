package suixiang.树;

import java.util.HashMap;
import java.util.Map;

/*437. 路径总和 III
        中等
        相关标签
        相关企业
        给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。

        路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。



        示例 1：



        输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        输出：3
        解释：和等于 8 的路径有 3 条，如图所示。
        示例 2：

        输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        输出：3


        提示:

        二叉树的节点个数的范围是 [0,1000]
        -109 <= Node.val <= 109
        -1000 <= targetSum <= 1000
        https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked*/
public class 路径总和3 {

/*    链接：https://leetcode.cn/problems/path-sum-iii/solutions/1021296/lu-jing-zong-he-iii-by-leetcode-solution-z9td/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }

}
