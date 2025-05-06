package suixiang.栈与队列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*347. 前 K 个高频元素
        中等
        相关标签
        相关企业
        给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。



        示例 1:

        输入: nums = [1,1,1,2,2,3], k = 2
        输出: [1,2]
        示例 2:

        输入: nums = [1], k = 1
        输出: [1]


        提示：

        1 <= nums.length <= 105
        k 的取值范围是 [1, 数组中不相同的元素的个数]
        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的


        进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。*/
public class 前k个高频元素 {
    //使用优先级队列的小顶端对map集合进行排序处理
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        //使用map集合对元素出现个数进行统计
        for (int num : nums) {
           map.put(num,map.getOrDefault(num,0)+1);
        }

        //使用优先级队列（小顶端）保存前k个高频数字
        PriorityQueue<int[]> small = new PriorityQueue<>((s1,s2)->s1[1]-s2[1]);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int[] num={entry.getKey(),entry.getValue()};
            //当队列小于k时直接添加，添加后队列中的数字按照出现频率从小到大排列，peek返回队顶频率最小数字
            if(small.size()<k){
                small.add(num);
            }else {
                int[] peek = small.peek();
                //当队列大于k时，判断新的数字出现频率是否大于队列中出现频率最小的数字
                //大于则替换
                if(peek[1]>=num[1]) continue;
                small.poll();
                small.add(num);
            }
        }
        //倒序构建结果数组
        int[] res=new int[k];
        for (int i = k-1; i >=0 ; i--) {
            res[i]=small.poll()[0];
        }
       return res;
    }

}
