package suixiang.数组.长度最小的子数组;

/*209. 长度最小的子数组
        中等
        相关标签
        相关企业
        给定一个含有 n 个正整数的数组和一个正整数 target 。

        找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。



        示例 1：

        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        示例 2：

        输入：target = 4, nums = [1,4,4]
        输出：1
        示例 3：

        输入：target = 11, nums = [1,1,1,1,1,1,1,1]
        输出：0
        https://leetcode.cn/problems/minimum-size-subarray-sum/*/
public class 长度最小的子数组 {


    public int minSubArrayLen(int target, int[] nums) {


        //滑动窗口：
        // 1.调整窗口的起始和结束位置，首先移动窗口结束位置，
        // 2.当窗口内的元素和大于target时，如果此时窗口长度小于已记录长度，更新最小窗口长度
        // 3.移动窗口起始位置至窗口内元素小于target，再次期间不断更新窗口最小长度

        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;//设置窗口起始最小长度为最大整数，以便初始更新最小长度
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);//注意r-l需要加一
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
