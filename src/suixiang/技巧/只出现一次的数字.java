package suixiang.技巧;
/*136. 只出现一次的数字
        已解答
简单
        相关标签
premium lock icon
        相关企业
提示
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。



示例 1 ：

输入：nums = [2,2,1]

输出：1

示例 2 ：

输入：nums = [4,1,2,1,2]

输出：4

示例 3 ：

输入：nums = [1]

输出：1



提示：

        1 <= nums.length <= 3 * 104
        -3 * 104 <= nums[i] <= 3 * 104
除了某个元素只出现一次以外，其余每个元素均出现两次。*/
public class 只出现一次的数字 {
    //思路：
    //使用位运算
    //异或运算有以下三个性质。
    //
    //任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
    //任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
    //异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。


    /*https://leetcode.cn/problems/single-number/solutions/242211/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked*/
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;//循环进行异或运算，直到所有数字异或运算结束，结果就是只出现一次的数字
        }
        return ans;
    }
}
