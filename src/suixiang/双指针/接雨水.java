package suixiang.双指针;

import com.sun.source.tree.WhileLoopTree;

/*42. 接雨水
        困难
        相关标签
        相关企业
        给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。



        示例 1：



        输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        输出：6
        解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        示例 2：

        输入：height = [4,2,0,3,2,5]
        输出：9


        提示：

        n == height.length
        1 <= n <= 2 * 104
        0 <= height[i] <= 105*/
public class 接雨水 {
  /*  方法三：双指针
    动态规划的做法中，需要维护两个数组 leftMax 和 rightMax，因此空间复杂度是 O(n)。是否可以将空间复杂度降到 O(1)？

    注意到下标 i 处能接的雨水量由 leftMax[i] 和 rightMax[i] 中的最小值决定。由于数组 leftMax 是从左往右计算，数组 rightMax 是从右往左计算，因此可以使用双指针和两个变量代替两个数组。

    维护两个指针 left 和 right，以及两个变量 leftMax 和 rightMax，初始时 left=0,right=n−1,leftMax=0,rightMax=0。指针 left 只会向右移动，指针 right 只会向左移动，在移动指针的过程中维护两个变量 leftMax 和 rightMax 的值。

    当两个指针没有相遇时，进行如下操作：

    使用 height[left] 和 height[right] 的值更新 leftMax 和 rightMax 的值；

    如果 height[left]<height[right]，则必有 leftMax<rightMax，下标 left 处能接的雨水量等于 leftMax−height[left]，将下标 left 处能接的雨水量加到能接的雨水总量，然后将 left 加 1（即向右移动一位）；

    如果 height[left]≥height[right]，则必有 leftMax≥rightMax，下标 right 处能接的雨水量等于 rightMax−height[right]，将下标 right 处能接的雨水量加到能接的雨水总量，然后将 right 减 1（即向左移动一位）。

    当两个指针相遇时，即可得到能接的雨水总量。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int trap(int[] height) {
         if(height.length==0||height==null) return 0;

         int left=0,right=height.length-1;
         int leftMax= 0,rightMax=0;
         int ans=0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);    // 更新左侧最大值
            rightMax = Math.max(rightMax, height[right]);  // 更新右侧最大值

            if (height[left] < height[right]) {
                // 左指针位置的高度更小，说明其水量由左侧最大值决定
                //每次移动较低的一边，保证了每次判断的时候当前格子的水量一定取决于较低的一边
                ans += leftMax - height[left];
                ++left;  // 左指针右移
            } else {
                // 右指针位置的高度更小或相等，说明其水量由右侧最大值决定
                ans += rightMax - height[right];
                --right;  // 右指针左移
            }
        }
        return ans;
    }
}
