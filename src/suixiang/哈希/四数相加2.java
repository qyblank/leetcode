package suixiang.哈希;

import java.util.HashMap;
import java.util.Map;

/*454. 四数相加 II
        中等
        相关标签
        相关企业
        给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        示例 1：

        输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
        输出：2
        解释：
        两个元组如下：
        1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
        2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
        示例 2：

        输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
        输出：1
        https://leetcode.cn/problems/4sum-ii/description/*/
public class 四数相加2 {
   /* 方法一：分组 + 哈希表
            思路与算法*/

  /*  我们可以将四个数组分成两部分，A 和 B 为一组，C 和 D 为另外一组。

    对于 A 和 B，我们使用二重循环对它们进行遍历，得到所有 A[i]+B[j] 的值并存入哈希映射中。对于哈希映射中的每个键值对，每个键表示一种 A[i]+B[j]，对应的值为 A[i]+B[j] 出现的次数。

    对于 C 和 D，我们同样使用二重循环对它们进行遍历。当遍历到 C[k]+D[l] 时，如果 −(C[k]+D[l]) 出现在哈希映射中，那么将 −(C[k]+D[l]) 对应的值累加进答案中。

    最终即可得到满足 A[i]+B[j]+C[k]+D[l]=0 的四元组数目。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/4sum-ii/solutions/499745/si-shu-xiang-jia-ii-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int num=0;
        HashMap<Integer,Integer> map12=numsSum(nums1,nums2);
        HashMap<Integer, Integer> map34 = numsSum(nums3, nums4);
        for (Map.Entry<Integer, Integer> entry1 : map12.entrySet()) {
            int num1=entry1.getValue();
            if(map34.containsKey(0-entry1.getKey())){
                int num2=map34.get(0- entry1.getKey());
                num+=num1*num2;
            }
        }
        return num;
    }

    private HashMap<Integer, Integer> numsSum(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                int sum=i+i1;
                if(map.containsKey(sum)) {
                    map.put(sum,map.get(sum)+1);
                } else map.put(sum,1);
            }
        }
        return map;
    }

}
