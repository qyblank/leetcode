package suixiang.树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*199. 二叉树的右视图
        中等
        相关标签
        相关企业
        给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。



        示例 1：

        输入：root = [1,2,3,null,5,null,4]

        输出：[1,3,4]

        解释：



        示例 2：

        输入：root = [1,2,3,4,null,null,null,5]

        输出：[1,3,4,5]

        解释：



        示例 3：

        输入：root = [1,null,3]

        输出：[1,3]

        示例 4：

        输入：root = []

        输出：[]



        提示:

        二叉树的节点个数的范围是 [0,100]
        -100 <= Node.val <= 100
        https://leetcode.cn/problems/binary-tree-right-side-view/description/*/
public class 二叉树的右视图 {
    //通过队列实现层序遍历，但是每次只保存每一层的最后一个节点值
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return List.of();

        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> deque =new LinkedList<>();
        deque.add(root);

        while(!deque.isEmpty()){
            int n=deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode poll = deque.poll();
                if(i==n-1) {
                    list.add(poll.val);
                }
                if(poll.left!=null) deque.add(poll.left);
                if(poll.right!=null) deque.add(poll.right);
            }
        }
        return list;
    }
}
