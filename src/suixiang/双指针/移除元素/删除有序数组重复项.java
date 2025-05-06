package suixiang.双指针.移除元素;
/*26. 删除有序数组中的重复项
        已解答
        简单
        相关标签
        相关企业
        提示
        给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，
        使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */

/*  考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：

  更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
  nums 的其余元素与 nums 的大小不重要。
 */
 /* 返回 k 。
  https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/*/
public class 删除有序数组重复项 {

    //解法一
    public int removeDuplicates(int[] nums) {
        //基本思路：遍历数组，每当遇到一个新的数，唯一元素k加一，并将该新数储存到数组k位置
        if(nums.length==0) return 0;
        int num=1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[num-1]){
                nums[num]=nums[i];
                num++;
            }
        }
        return num;
    }

    //解法二：快慢指针
    public int removeDuplicates2(int[] nums) {
        //定义两个指针 fast 和 slow 分别为快指针和慢指针，快指针表示遍历数组到达的下标位置，慢指针表示下一个不同元素要填入的下标位置，初始时两个指针都指向下标 1。
        //
        //假设数组 nums 的长度为 n。将快指针 fast 依次遍历从 1 到 n−1 的每个位置，对于每个位置，如果 nums[fast]
        //
        //=nums[fast−1]，说明 nums[fast] 和之前的元素都不同，因此将 nums[fast] 的值复制到 nums[slow]，然后将 slow 的值加 1，即指向下一个位置。
        //
        //作者：力扣官方题解
        //链接：https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solutions/728105/shan-chu-pai-xu-shu-zu-zhong-de-zhong-fu-tudo/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
