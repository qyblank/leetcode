package suixiang.树;
/*94. 二叉树的中序遍历
        简单
        相关标签
        相关企业
        给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。



        示例 1：


        输入：root = [1,null,2,3]
        输出：[1,3,2]
        示例 2：

        输入：root = []
        输出：[]
        示例 3：

        输入：root = [1]
        输出：[1]


        提示：

        树中节点数目在范围 [0, 100] 内
        -100 <= Node.val <= 100


        进阶: 递归算法很简单，你可以通过迭代算法完成吗？*/


import java.util.ArrayList;
import java.util.List;

public class 二叉树中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        iTraversal1(list,root);
        return list;
    }

    public void iTraversal1(List<Integer> list,TreeNode node){
        if(node!=null){
            iTraversal1(list,node.left);
            list.add(node.val);
            iTraversal1(list,node.right);
        }
    }


}
