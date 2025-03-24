package suixiang.数组.二分法;


/*
代码
        测试用例
        测试结果
        测试结果
        35. 搜索插入位置
        已解答
        简单
        相关标签
        相关企业
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        请必须使用时间复杂度为 O(log n) 的算法。



        示例 1:

        输入: nums = [1,3,5,6], target = 5
        输出: 2
        示例 2:

        输入: nums = [1,3,5,6], target = 2
        输出: 1
        示例 3:

        输入: nums = [1,3,5,6], target = 7
        输出: 4



        https://leetcode.cn/problems/search-insert-position/description/
*/


public class 搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        //左闭右闭写法[left,right]
        // 与二分查找的区别：
        //二分查找left<=right的条件在left=right=nums.length-1或者left=right=0时导致数组元素溢出
        //所循环条件改为left<right

        int left = 0;
        int right = nums.length-1; // 定义target在左闭右闭的区间里，[left, right]
        while (left < right) { // 当left==right，区间[left, right]依然有效，所以用 <=
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值，直接返回下标
            }
        }
        // 未找到目标值
        if(nums[left]<target) return left+1;
        return left;
    }
}
