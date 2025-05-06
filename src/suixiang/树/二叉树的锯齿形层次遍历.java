package suixiang.树;

import org.w3c.dom.Node;

import java.util.*;

public class 二叉树的锯齿形层次遍历 {
   /* \我们依然可以沿用第 102 题的思想，修改广度优先搜索，对树进行逐层遍历，用队列维护当前层的所有元素，
   当队列不为空的时候，求得当前队列的长度 size，每次从队列中取出 size 个元素进行拓展，然后进行下一次迭代。

    为了满足题目要求的返回值为「先从左往右，再从右往左」交替输出的锯齿形，
    我们可以利用「双端队列」的数据结构来维护当前层节点值输出的顺序。

    双端队列是一个可以在队列任意一端插入元素的队列。在广度优先搜索遍历当前层节点拓展下一层节点的时候我们仍然从左往右按顺序拓展，
    但是对当前层节点的存储我们维护一个变量 isOrderLeft 记录是从左至右还是从右至左的：

    如果从左至右，我们每次将被遍历到的元素插入至双端队列的末尾。

    如果从右至左，我们每次将被遍历到的元素插入至双端队列的头部。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/solutions/530400/er-cha-shu-de-ju-chi-xing-ceng-xu-bian-l-qsun/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       // 用于存储最终的锯齿形层序遍历结果
       List<List<Integer>> ans = new LinkedList<List<Integer>>();
       // 如果根节点为空，直接返回空列表
       if (root == null) {
           return ans;
       }

       // 使用队列来进行层序遍历，存储待处理的节点
       Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
       // 将根节点加入队列
       nodeQueue.offer(root);
       // 用于标记当前层的遍历顺序，true 表示从左到右，false 表示从右到左
       boolean isOrderLeft = true;

       // 当队列不为空时，继续进行层序遍历
       while (!nodeQueue.isEmpty()) {
           // 用于存储当前层的节点值，使用双端队列方便按不同顺序添加元素
           Deque<Integer> levelList = new LinkedList<Integer>();
           // 获取当前层的节点数量
           int size = nodeQueue.size();
           // 遍历当前层的所有节点
           for (int i = 0; i < size; ++i) {
               // 从队列中取出一个节点
               //从队列里取一个节点就直接处理一个节点
               //将节点的值保存和子节点保存分开处理
               TreeNode curNode = nodeQueue.poll();
               // 根据当前层的遍历顺序，将节点值添加到双端队列的不同位置
               if (isOrderLeft) {
                   // 从左到右时，将节点值添加到双端队列的末尾
                   levelList.offerLast(curNode.val);
               } else {
                   // 从右到左时，将节点值添加到双端队列的开头
                   levelList.offerFirst(curNode.val);
               }
               // 如果当前节点的左子节点不为空，将其加入队列
               if (curNode.left != null) {
                   nodeQueue.offer(curNode.left);
               }
               // 如果当前节点的右子节点不为空，将其加入队列
               if (curNode.right != null) {
                   nodeQueue.offer(curNode.right);
               }
           }
           // 将当前层的节点值列表添加到最终结果列表中
           ans.add(new LinkedList<Integer>(levelList));
           // 切换下一层的遍历顺序
           isOrderLeft = !isOrderLeft;
       }

       // 返回最终的锯齿形层序遍历结果
       return ans;
   }

}
