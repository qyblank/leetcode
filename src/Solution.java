class Solution {
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