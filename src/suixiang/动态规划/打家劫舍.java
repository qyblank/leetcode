package suixiang.动态规划;

import java.util.ArrayList;
import java.util.List;

/*198. 打家劫舍
        中等
相关标签
premium lock icon
        相关企业
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
偷窃到的最高金额 = 2 + 9 + 1 = 12 。


提示：

        1 <= nums.length <= 100
        0 <= nums[i] <= 400*/
public class 打家劫舍 {
    public int rob(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();

        ArrayList<Integer> l0 = new ArrayList<Integer>();
        l0.add(nums[0]);
        l0.add(0);
        list.add(l0);
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        if(nums[1]>nums[0]){
            l1.add(nums[1]);
            l1.add(1);
        }else {
            l1.add(nums[0]);
            l1.add(0);
        }
        list.add(l1);

        for (int i = 2; i < nums.length; i++) {
            ArrayList<Integer> integers1 = new ArrayList<Integer>();
            List<Integer> integers = list.get(i - 1);
            List<Integer> integers2 = list.get(i - 2);
            if(integers.get(1)==0){
                integers1.add(integers.get(0)+nums[i]);
                integers1.add(1);
            }else if(integers.get(1)==1){
                if(integers2.get(0)+nums[i]>integers.get(0)){
                    integers1.add(integers2.get(0)+nums[i]);
                    integers1.add(1);
                }else {
                    integers1.add(integers.get(0));
                    integers1.add(0);
                }
            }
            list.add(integers1);
        }

        return list.get(nums.length-1).get(0);
    }
}
