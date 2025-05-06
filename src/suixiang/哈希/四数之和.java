package suixiang.哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*18. 四数之和
        已解答
        中等
        相关标签
        相关企业
        给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

        0 <= a, b, c, d < n
a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。



        示例 1：

        输入：nums = [1,0,-1,0,-2,2], target = 0
        输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        示例 2：

        输入：nums = [2,2,2,2,2], target = 8
        输出：[[2,2,2,2]]


        提示：

        1 <= nums.length <= 200
        -109 <= nums[i] <= 109
        -109 <= target <= 109*/
public class 四数之和 {

    //思路：参考三数之和
    //方法一：排序 + 双指针
    //思路与算法
    //
    //最朴素的方法是使用四重循环枚举所有的四元组，然后使用哈希表进行去重操作，得到不包含重复四元组的最终答案。假设数组的长度是 n，则该方法中，枚举的时间复杂度为 O(n
    //4
    // )，去重操作的时间复杂度和空间复杂度也很高，因此需要换一种思路。
    //
    //为了避免枚举到重复四元组，则需要保证每一重循环枚举到的元素不小于其上一重循环枚举到的元素，且在同一重循环中不能多次枚举到相同的元素。
    //
    //为了实现上述要求，可以对数组进行排序，并且在循环过程中遵循以下两点：
    //
    //每一种循环枚举到的下标必须大于上一重循环枚举到的下标；
    //
    //同一重循环中，如果当前元素与上一个元素相同，则跳过当前元素。
    //
    //使用上述方法，可以避免枚举到重复四元组，但是由于仍使用四重循环，时间复杂度仍是 O(n
    //4
    // )。注意到数组已经被排序，因此可以使用双指针的方法去掉一重循环。
    //
    //使用两重循环分别枚举前两个数，然后在两重循环枚举到的数之后使用双指针枚举剩下的两个数。假设两重循环枚举到的前两个数分别位于下标 i 和 j，其中 i<j。初始时，左右指针分别指向下标 j+1 和下标 n−1。每次计算四个数的和，并进行如下操作：
    //
    //如果和等于 target，则将枚举到的四个数加到答案中，然后将左指针右移直到遇到不同的数，将右指针左移直到遇到不同的数；
    //
    //如果和小于 target，则将左指针右移一位；
    //
    //如果和大于 target，则将右指针左移一位。
    //
    //使用双指针枚举剩下的两个数的时间复杂度是 O(n)，因此总时间复杂度是 O(n
    //3
    // )，低于 O(n
    //4
    // )。
    //
    //具体实现时，还可以进行一些剪枝操作：
    //
    //在确定第一个数之后，如果 nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target，说明此时剩下的三个数无论取什么值，四数之和一定大于 target，因此退出第一重循环；
    //在确定第一个数之后，如果 nums[i]+nums[n−3]+nums[n−2]+nums[n−1]<target，说明此时剩下的三个数无论取什么值，四数之和一定小于 target，因此第一重循环直接进入下一轮，枚举 nums[i+1]；
    //在确定前两个数之后，如果 nums[i]+nums[j]+nums[j+1]+nums[j+2]>target，说明此时剩下的两个数无论取什么值，四数之和一定大于 target，因此退出第二重循环；
    //在确定前两个数之后，如果 nums[i]+nums[j]+nums[n−2]+nums[n−1]<target，说明此时剩下的两个数无论取什么值，四数之和一定小于 target，因此第二重循环直接进入下一轮，枚举 nums[j+1]。
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/4sum/solutions/436368/si-shu-zhi-he-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //枚举b
            for (int second=first+1;second<n;second++){
                if (second > first+1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //考虑数字相加超过int最大值情况
                long ntarget=(long)target-nums[first]-nums[second];
                for(int third=second+1,four=n-1;third<four;third++){
                    if (third > second+1 && nums[third] == nums[third - 1]) {
                        continue;
                    }
                    // 需要保证 b 的指针在 c 的指针的左侧
                    while (third < four && nums[third] + nums[four] > ntarget) {
                        --four;
                    }
                    // 如果指针重合，随着 b 后续的增加
                    // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                    if (four == third) {
                        break;
                    }
                    if (nums[four] + nums[third] == ntarget) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[four]);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

}
