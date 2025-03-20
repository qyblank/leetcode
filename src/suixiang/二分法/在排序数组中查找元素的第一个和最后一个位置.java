package suixiang.二分法;
/*
34. 在排序数组中查找元素的第一个和最后一个位置

        已解答
        中等
        相关标签
        相关企业
        给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

        如果数组中不存在目标值 target，返回 [-1, -1]。

        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。



        示例 1：

        输入：nums = [5,7,7,8,8,10], target = 8
        输出：[3,4]
        示例 2：

        输入：nums = [5,7,7,8,8,10], target = 6
        输出：[-1,-1]
        示例 3：

        输入：nums = [], target = 0
        输出：[-1,-1]

        https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
*/

public class 在排序数组中查找元素的第一个和最后一个位置 {
    /* 寻找target在数组里的左右边界，有如下三种情况：

        情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
        情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
        情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
        这三种情况都考虑到，说明就想的很清楚了。

        接下来，在去寻找左边界，和右边界了。

        采用二分法来去寻找左右边界，为了让代码清晰，我分别写两个二分来寻找左边界和右边界。*/
    public int[] searchRange(int[] nums, int target) {
        //左闭右闭写法[left,right]
        int left = 0;
        int right = nums.length-1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                int l=findleft(nums,left,middle,target);
                int r=findright(nums,middle,right,target);
                return new int[]{l,r};
            }
        }
        // 未找到目标值
        return new int[]{-1, -1};
    }



    //寻找左区间
    public int findleft(int[] nums,int left,int right,int target){
        //当left==right时必定处于target的边界上
        while (left<right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                right=middle-1;
            }else {
                left=middle+1;
            }
        }
        if(nums[left]==target) return left;
        return left+1;
    }

    //寻找右区间
    private int findright(int[] nums, int left, int right, int target) {
        while (left<right){
            int middle=left+(right-left)/2;
            if(nums[middle]==target){
                left=middle+1;
            }else {
                right=middle-1;
            }
        }
        if(nums[left]==target) return left;
        return left-1;
    }
}
