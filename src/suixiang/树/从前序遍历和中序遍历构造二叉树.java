package suixiang.树;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
        105. 从前序与中序遍历序列构造二叉树
        中等
        相关标签
        相关企业
        给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。



        示例 1:


        输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        输出: [3,9,20,null,null,15,7]
        示例 2:

        输入: preorder = [-1], inorder = [-1]
        输出: [-1]


        提示:

        1 <= preorder.length <= 3000
        inorder.length == preorder.length
        -3000 <= preorder[i], inorder[i] <= 3000
        preorder 和 inorder 均 无重复 元素
        inorder 均出现在 preorder
        preorder 保证 为二叉树的前序遍历序列
        inorder 保证 为二叉树的中序遍历序列
        https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked*/
public class 从前序遍历和中序遍历构造二叉树 {
    /*首先回忆一下如何根据两个顺序构造一个唯一的二叉树，相信理论知识大家应该都清楚，就是以 后序数组的最后一个元素为切割点，先切中序数组，根据中序数组，反过来再切后序数组。一层一层切下去，每次后序数组最后一个元素就是节点元素。

    如果让我们肉眼看两个序列，画一棵二叉树的话，应该分分钟都可以画出来。

    流程如图：

    106.从中序与后序遍历序列构造二叉树

    那么代码应该怎么写呢？

    说到一层一层切割，就应该想到了递归。

    来看一下一共分几步：

    第一步：如果数组大小为零的话，说明是空节点了。

    第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。

    第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点

    第四步：切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）

    第五步：切割后序数组，切成后序左数组和后序右数组

    第六步：递归处理左区间和右区间*/
    Map<Integer,Integer> inMap =new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
           if(preorder.length==0) return null;
        // 构造哈希映射，帮助我们快速定位根节点
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,preorder.length-1,0,inorder.length-1);

    }

    public TreeNode build(int[] pre,int[] in,int prestart,int preend,int instart,int inend){
        if(prestart>preend) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int n=pre[prestart];
        //构建跟节点
        TreeNode node=new TreeNode(n);
       //在中序遍历中查找节点位置
        int inc = inMap.get(n);
        // 得到左子树中的节点数目
        int lenleft=inc-instart;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        node.left=build(pre,in,prestart+1,prestart+lenleft,instart,inc-1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        node.right=build(pre,in,prestart+lenleft+1,preend,inc+1,inend);
        return node;
    }
}
