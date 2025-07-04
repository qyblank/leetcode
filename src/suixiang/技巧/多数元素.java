package suixiang.技巧;
/*169. 多数元素
        已解答
简单
        相关标签
premium lock icon
        相关企业
给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。



示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2


提示：
n == nums.length
1 <= n <= 5 * 104
        -109 <= nums[i] <= 109


进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。*/
public class 多数元素 {
    //思路： Boyer-Moore 投票算法
   //思路
    //如果我们把众数记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
    //Boyer-Moore 算法的本质和方法四中的分治十分类似。我们首先给出 Boyer-Moore 算法的详细步骤：
    //
    //我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
    //
    //我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
    //
    //如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
    //
    //如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
    //
    //在遍历完成后，candidate 即为整个数组的众数。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/majority-element/solutions/146074/duo-shu-yuan-su-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int majorityElement(int[] nums) {
        int ans=nums[0];
        int count=1;
        for (int num : nums) {
            if(num==ans){
                count++;
            }else{
                count--;
                if(count==0){
                    ans=num;
                    count=1;
                }
            }
            }
        return ans;
    }
}
