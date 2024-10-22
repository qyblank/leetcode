package code;/*
15. code.三数之和
        尝试过
        中等
        相关标签
        相关企业
        提示
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。





        示例 1：

        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
        示例 2：

        输入：nums = [0,1,1]
        输出：[]
        解释：唯一可能的三元组和不为 0 。
        示例 3：

        输入：nums = [0,0,0]
        输出：[[0,0,0]]
        解释：唯一可能的三元组和为 0 。


        提示：

        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105

*/


import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);//排序

        List<List<Integer>> Threesum=new ArrayList<>();

        for (int i = 0; i <nums.length-1 ;i++) {
           // System.out.println(i);
           int l=i+1,r=nums.length-1;

           while (l!=r){
               System.out.println(i+" "+l+" "+r);
               if(nums[l]+nums[r]==-nums[i]){
                   List<Integer> l1=new ArrayList<>();

                   Collections.addAll(l1,nums[i],nums[l],nums[r]);
                   Threesum.add(l1);
                  // System.out.println("333");
                   while (l!=r){
                       if(nums[r]==nums[r-1]){
                           r--;
                       }else {
                           r--;
                           break;
                       }
                   }
                   while (l!=r){

                       if(nums[l]==nums[l+1]){
                           l++;
                       }else {
                           l++;
                           break;
                       }
                   }
               }else if(nums[l]+nums[r]>-nums[i]){
                   while (l!=r){
                       if(nums[r]==nums[r-1]){
                           r--;
                       }else {
                           r--;
                           break;
                       }
                   }
               }else if(nums[l]+nums[r]<-nums[i]){

                   while (l!=r){

                       if(nums[l]==nums[l+1]){
                           l++;
                       }else {
                           l++;
                           break;
                       }
                   }
               }
           }
            while((nums[i+1]==nums[i])&&i<nums.length-2){//跳过相同的值
                i++;
            }
        }

        return Threesum;

    }
}
