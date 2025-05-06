package suixiang.树;
/*108. 将有序数组转换为二叉搜索树
        已解答
        简单
        相关标签
        相关企业
        给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。



        示例 1：


        输入：nums = [-10,-3,0,5,9]
        输出：[0,-3,9,-10,null,5]
        解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

        示例 2：


        输入：nums = [1,3]
        输出：[3,1]
        解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。


        提示：

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums 按 严格递增 顺序排列
        https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked*/
public class 将有序数组转化成二叉搜索树 {

    //思路：
    //寻找分割点，分割点作为当前节点，然后递归左区间和右区间。
    public TreeNode sortedArrayToBST(int[] nums) {
          if(nums.length==0) return null;
          return create(nums,0,nums.length-1);
    }

    public TreeNode create(int[] nums ,int start,int end){
        if(start>end) return null;

        int n=(start+end)/2;
        TreeNode node = new TreeNode(nums[n]);

        node.left=create(nums,start,n-1);
        node.right=create(nums,n+1,end);
        return node;
    }
}
