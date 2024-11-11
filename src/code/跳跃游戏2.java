package code;

/*45. 跳跃游戏 II
        中等
        相关标签
        相关企业
        给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。

        每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:

        0 <= j <= nums[i]
        i + j < n
返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。



        示例 1:

        输入: nums = [2,3,1,1,4]
        输出: 2
        解释: 跳到最后一个位置的最小跳跃数是 2。
        从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
        示例 2:

        输入: nums = [2,3,0,1,4]
        输出: 2


        提示:

        1 <= nums.length <= 104
        0 <= nums[i] <= 1000
        题目保证可以到达 nums[n-1]*/

public class 跳跃游戏2 {
    public int jump(int[] nums) {
               /*思路：计算累计最大跳跃数，当跳到n时最大跳跃数为n+nums[n]，
                如果此时最大跳跃数大于数组长度，则可以跳到最后，
                如果此时最大跳跃数等于n，即nums[n]=0，则不可跳到最后
                如果此时最大跳跃数大于n但小于nums.length，则从n的后nums[n]个选项中选择累计跳跃数最大的那个跳跃   */


        //优化：无需两层遍历，只需按照数组顺序遍历，通过当前maxjump最大值处判断该下标是否可达
        //如果可达则判断是否能更新maxjump，更新之后是否大于尾下标，不可则继续遍历，如果该下标不可达，判断是否为尾下标如不是则返回false
        if(nums.length==0||(nums.length==1)) return 0;
        int maxJump=nums[0];
        int sum=0;
        for (int i = 0; i < nums.length;) {
            if(maxJump>= nums.length-1) return sum+1;
            int temp=0;
            // System.out.println(i);
            for (int j = 1; j <= nums[i]; j++) {
                // System.out.println(i+j+nums[i+j]+","+maxJump);
                if(i+j+nums[i+j]>=maxJump){
                    maxJump=i+j+nums[i+j];
                    temp=i+j;
                }
            }
            sum++;
            i=temp;
        }
        return sum;
    }
}
