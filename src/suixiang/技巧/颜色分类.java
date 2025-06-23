package suixiang.技巧;

import static java.util.Collections.swap;

/*75. 颜色分类
        中等
相关标签
premium lock icon
        相关企业
提示
给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

必须在不使用库内置的 sort 函数的情况下解决这个问题。



示例 1：

输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
示例 2：

输入：nums = [2,0,1]
输出：[0,1,2]


提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2


进阶：

你能想出一个仅使用常数空间的一趟扫描算法吗？*/
public class 颜色分类 {
   /* 此算法采用 双指针 方法实现对数组的一趟扫描排序：
    使用两个指针：
    left 指向当前应放置 0 的位置。
    right 指向当前应放置 2 的位置。
    遍历数组时使用索引 i，根据 nums[i] 的值执行以下操作：
    如果 nums[i] == 0，将其与 nums[left] 交换，并同时递增 left 和 i。
    如果 nums[i] == 2，将其与 nums[right] 交换，并递减 right。
    如果 nums[i] == 1，直接递增 i。
    这样可以在一次遍历中完成排序，时间复杂度为 O(n)，空间复杂度为 O(1)。
    关键点：
    1. 在对right进行替换后，right--，i不变，i++，i<right
    */
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        int temp=0;
        for (int i = 0; i < right;) {
            if(nums[i]==0){
                temp=nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
                left++;
                i++;
            } else if (nums[i] == 2) {
                temp=nums[right];
                nums[right]=nums[i];
                nums[i]=temp;
                right--;
            }else i++;
        }
    }
}
