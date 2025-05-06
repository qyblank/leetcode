package suixiang.双指针.移除元素;

/*283. 移动零
        简单
        相关标签
        相关企业
        提示
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        https://leetcode.cn/problems/move-zeroes/description/*/
public class 移动零 {
    public void moveZeroes(int[] nums) {
        //快慢指针
        //只要快指针不为零直接与慢指针置换

        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast]!=0){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
    }
}
