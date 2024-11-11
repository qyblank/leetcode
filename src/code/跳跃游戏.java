package code;
/*55. 跳跃游戏
        中等
        相关标签
        相关企业
        给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

        判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。



        示例 1：

        输入：nums = [2,3,1,1,4]
        输出：true
        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
        示例 2：

        输入：nums = [3,2,1,0,4]
        输出：false
        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


        提示：

        1 <= nums.length <= 104
        0 <= nums[i] <= 105*/
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        /*思路：计算累计最大跳跃数，当跳到n时最大跳跃数为n+nums[n]，
                如果此时最大跳跃数大于数组长度，则可以跳到最后，
                如果此时最大跳跃数等于n，即nums[n]=0，则不可跳到最后
                如果此时最大跳跃数大于n但小于nums.length，则从n的后nums[n]个选项中选择累计跳跃数最大的那个跳跃   */


        //优化：无需两层遍历，只需按照数组顺序遍历，通过当前maxjump最大值处判断该下标是否可达
        //如果可达则判断是否能更新maxjump，更新之后是否大于尾下标，不可则继续遍历，如果该下标不可达，判断是否为尾下标如不是则返回false
        if(nums.length==0||(nums.length==1&&nums[0]==0)) return true;
        int maxJump=nums[0];
        for (int i = 0; i < nums.length;) {
            if(maxJump>= nums.length-1) return true;
            if(maxJump==i) return false;
            int temp=0;
            System.out.println(i);
            for (int j = 1; j <= nums[i]; j++) {
                System.out.println(i+j+nums[i+j]+","+maxJump);
                if(i+j+nums[i+j]>=maxJump){
                    maxJump=i+j+nums[i+j];
                    temp=i+j;
                }
            }
            i=temp;
        }
        return false;
    }

}
