package suixiang.双指针.移除元素;
/*977. 有序数组的平方
        简单
        相关标签
        相关企业
        给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。



        示例 1：

        输入：nums = [-4,-1,0,3,10]
        输出：[0,1,9,16,100]
        解释：平方后，数组变为 [16,1,0,9,100]
        排序后，数组变为 [0,1,9,16,100]
        示例 2：

        输入：nums = [-7,-3,2,3,11]
        输出：[4,9,9,49,121]
        https://leetcode.cn/problems/squares-of-a-sorted-array/description/*/
public class 有序数组的平方 {

    //方法二：双指针
    //思路与算法
    //
    //方法一没有利用「数组 nums 已经按照升序排序」这个条件。显然，如果数组 nums 中的所有数都是非负数，那么将每个数平方后，数组仍然保持升序；如果数组 nums 中的所有数都是负数，那么将每个数平方后，数组会保持降序。
    //
    //这样一来，如果我们能够找到数组 nums 中负数与非负数的分界线，那么就可以用类似「归并排序」的方法了。
    // 具体地，我们设 neg 为数组 nums 中负数与非负数的分界线，也就是说，nums[0] 到 nums[neg] 均为负数，而 nums[neg+1] 到 nums[n−1] 均为非负数。
    // 当我们将数组 nums 中的数平方后，那么 nums[0] 到 nums[neg] 单调递减，nums[neg+1] 到 nums[n−1] 单调递增。
    //
    //由于我们得到了两个已经有序的子数组，因此就可以使用归并的方法进行排序了。具体地，使用两个指针分别指向位置 neg 和 neg+1，每次比较两个指针对应的数，选择较小的那个放入答案并移动指针。当某一指针移至边界时，将另一指针还未遍历到的数依次放入答案。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/squares-of-a-sorted-array/solutions/447736/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int negative = -1;
            for (int i = 0; i < n; ++i) {
                if (nums[i] < 0) {
                    negative = i;
                } else {
                    break;
                }
            }

            int[] ans = new int[n];
            int index = 0, i = negative, j = negative + 1;
            while (i >= 0 || j < n) {
                if (i < 0) {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                } else if (j == n) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                    ans[index] = nums[i] * nums[i];
                    --i;
                } else {
                    ans[index] = nums[j] * nums[j];
                    ++j;
                }
                ++index;
            }

            return ans;
        }
/*
    方法三：双指针
            思路与算法

    同样地，我们可以使用两个指针分别指向位置 0 和 n−1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。这种方法无需处理某一指针移动至边界的情况，读者可以仔细思考其精髓所在。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/squares-of-a-sorted-array/solutions/447736/you-xu-shu-zu-de-ping-fang-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
        public int[] sortedSquares2(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
                if (nums[i] * nums[i] > nums[j] * nums[j]) {
                    ans[pos] = nums[i] * nums[i];
                    ++i;
                } else {
                    ans[pos] = nums[j] * nums[j];
                    --j;
                }
                --pos;
            }
            return ans;
        }



}
