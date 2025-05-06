package suixiang.双指针.移除元素;
/*27. 移除元素
        已解答
        简单
        相关标签
        相关企业
        提示
        给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。

        假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：

        更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
        返回 k*/
public class 移除元素 {
    public int removeElement(int[] nums, int val) {
        //思路：快慢指针，快指针每回合都要移动，慢指针只有nums[slow]!=val时移动
        int fast=0;
        int slow=0;
        int newLen=0;
        while (fast<=nums.length-1){
            //   System.out.println(fast+"   "+slow);
            int nf=nums[fast];
            int ns=nums[slow];
            if(nf!=val&&ns==val){
                nums[slow]=nums[fast];
                nums[fast]=val;
                slow++;
                newLen++;
                continue;
            }
            if(ns!=val) {
                slow++;
                newLen++;
            };
            fast++;
        }
        return newLen;
    }

}
