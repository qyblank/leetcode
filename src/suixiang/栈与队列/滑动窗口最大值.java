package suixiang.栈与队列;

import javax.swing.*;
import java.util.*;

/*239. 滑动窗口最大值
        尝试过
        困难
        相关标签
        相关企业
        提示
        给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

        返回 滑动窗口中的最大值 。



        示例 1：

        输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        输出：[3,3,5,5,6,7]
        解释：
        滑动窗口的位置                最大值
        ---------------               -----
        [1  3  -1] -3  5  3  6  7       3
        1 [3  -1  -3] 5  3  6  7       3
        1  3 [-1  -3  5] 3  6  7       5
        1  3  -1 [-3  5  3] 6  7       5
        1  3  -1  -3 [5  3  6] 7       6
        1  3  -1  -3  5 [3  6  7]      7
        示例 2：

        输入：nums = [1], k = 1
        输出：[1]


        提示：

        1 <= nums.length <= 105
        -104 <= nums[i] <= 104
        1 <= k <= nums.length*/
public class 滑动窗口最大值 {

    //暴力循环查找最大值,超出时间
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int left = 0, right = k - 1;
        List<Integer> maxList = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        maxList.add(maxValue);

        int lastLeft = nums[0];
        left++;
        right++;
        int in = 0, out = 0;
        for (int i = 1; right < nums.length; i++, left++, right++) {
            in = nums[right];
            out = nums[left - 1];
            if (in >= maxList.get(i - 1)) {
                maxList.add(in);
            } else if (out < maxList.get(i - 1)) {
                maxList.add(maxList.get(i - 1));
            } else if (out == maxList.get(i - 1)) {
                maxValue = Integer.MIN_VALUE;
                for (int j = left; j <= right; j++) {
                    if (nums[j] > maxValue) {
                        maxValue = nums[j];
                    }
                }
                maxList.add(maxValue);
            }
        }

        int[] result = new int[maxList.size()];
        for (int i = 0; i < maxList.size(); i++) {
            result[i] = maxList.get(i);
        }
        return result;
    }




    //方法二：通过自定义的单调队列维护滑动窗口内的元素并返回最大值
    public int[] maxSlidingWindow2(int[] nums, int k){
        int left = 0, right = k - 1;

        int len = nums.length - k + 1;
        //存放结果元素的数组
        int[] res = new int[len];

        Myqueue myqueue = new Myqueue();
        for (int i = 0; i <= right; i++) {
            myqueue.add(nums[i]);
        }
        res[0]=myqueue.peek();
        left++;
        right++;
        for (int i = 1; right<nums.length; i++,left++,right++) {

            myqueue.poll(nums[left-1]);

            myqueue.add(nums[right]);

            res[i]=myqueue.peek();
        }

        return res;
    }

    //方法三：使用双端队列实现单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            // 2.维护单调递减队列：新元素若大于队尾元素，则弹出队尾元素，直到满足单调性
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if(i >= k - 1){
                res[idx++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
//自定义单调队列
//特点：
//1.该队列是有序队列，最大值永远在头部
//2.在添加时，添加值会从尾部开始替换掉所有小于他的数
//  此操作保证队列有序性，同时使队列只关注于窗口中的可能最大值
//3.在移除元素时，如果队顶元素等于移除元素则说明移除元素为最大值，如果不等于则说明，移除元素不是最大值无需关注
//4.返回时，队顶元素
class Myqueue{
    Deque<Integer> deque =new LinkedList<>();

    void poll(int val){
        if (!deque.isEmpty() && val == deque.peek()) {
            deque.poll();
        }
    }
    void add(int val) {
        while (!deque.isEmpty() && val > deque.getLast()) {
            deque.removeLast();
        }
        deque.add(val);
    }

    int peek(){
        return deque.peek();
    }


}