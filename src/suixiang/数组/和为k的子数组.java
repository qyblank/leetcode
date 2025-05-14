package suixiang.数组;

import java.util.HashMap;
import java.util.Map;

/*560. 和为 K 的子数组
        中等
        相关标签
        相关企业
        提示
        给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。

        子数组是数组中元素的连续非空序列。



        示例 1：

        输入：nums = [1,1,1], k = 2
        输出：2
        示例 2：

        输入：nums = [1,2,3], k = 3
        输出：2


        提示：

        1 <= nums.length <= 2 * 104
        -1000 <= nums[i] <= 1000
        -107 <= k <= 107
        https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked*/
public class 和为k的子数组 {

        public int subarraySum ( int[] nums, int k){
            Map<Integer, Integer> prefixCount = new HashMap<>();
            prefixCount.put(0, 1); // 初始化前缀和为0的出现次数一次
            int sum = 0;
            int count = 0;

            for (int num : nums) {
                sum += num; // 累加当前前缀和
                // 如果存在前缀和为 sum - k 的情况，说明当前有一段子数组和为 k
                count += prefixCount.getOrDefault(sum - k, 0);
                // 将当前前缀和记录到哈希表中
                prefixCount.merge(sum, 1, Integer::sum);
            }
            return count;
        }

}
