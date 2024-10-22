package code;/*
11. 盛最多水的容器

        给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

        返回容器可以储存的最大水量。

        说明：你不能倾斜容器。



        示例 1：



        输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
        示例 2：

        输入：height = [1,1]
        输出：1


        提示：

        n == height.length
        2 <= n <= 105
        0 <= height[i] <= 104


*/

public class maxArea {
        public int maxArea(int[] height) {
            // 初始化最大面积为0
            int ans = 0;
            // 获取数组长度
            int n = height.length;
            // 初始化左右指针，分别指向数组的开始和结束
            int left = 0, right = n - 1;

            // 当左指针小于右指针时，继续寻找更大的面积
            while(left < right) {
                // 计算当前左右指针指向的线段中的较小高度
                int mid = Math.min(height[left], height[right]);
                // 计算当前容器的面积，并与之前的最大面积比较，更新最大面积
                ans = Math.max(ans, mid * (right - left));

                // 移动左指针，直到找到一个比当前较小高度更大的值
                while(height[left] <= mid && left < right) {
                    left++;
                }

                // 移动右指针，直到找到一个比当前较小高度更大的值
                while(height[right] <= mid && left < right) {
                    right--;
                }
            }
            // 返回计算出的最大面积
            return ans;
        }



}
