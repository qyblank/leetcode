package code;/*
1. code.两数之和
        简单
        相关标签
        相关企业
        提示
        给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。

        你可以按任意顺序返回答案。



        示例 1：

        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
        示例 2：

        输入：nums = [3,2,4], target = 6
        输出：[1,2]
        示例 3：

        输入：nums = [3,3], target = 6
        输出：[0,1]


        提示：

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        只会存在一个有效答案


        进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
*/


import java.util.*;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        int[] sum=new int[2];
        List<st> list=new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            st s=new st(nums[i],i);
            list.add(s);
        }
        list.sort(Comparator.comparingInt(s -> s.num));
        int r=0;

        for (int i = 0; i < nums.length; i++) {
            //System.out.println(list.get(i).num);
            if(list.get(i).num>target) {
                r=i-1;
                break;
            }
        }
       //System.out.println(r);
        if(r<=0) r=nums.length-1;
        int l=0;

        for (;l<r; ) {
            int a=list.get(l).num+list.get(r).num;
            if(a==target) {
                sum[0]=list.get(l).s;
                sum[1]=list.get(r).s;
                return sum;
            }
            if(a>target) r--;
            if(a<target) l++;
        }
        return sum;
    }
    public class st{
        int num;
        int s;
        public st(int a,int b){
            num=a;
            s=b;
        }

    }

}
