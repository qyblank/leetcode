package code;

import java.util.*;

/*380. O(1) 时间插入、删除和获取随机元素
        中等
        相关标签
        相关企业
        实现RandomizedSet 类：

        RandomizedSet() 初始化 RandomizedSet 对象
        bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
        bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
        int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
        你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。



        示例：

        输入
        ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
        [[], [1], [2], [2], [], [1], [2], []]
        输出
        [null, true, false, true, 2, true, false, 2]

        解释
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
        randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
        randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
        randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。


        提示：

        -231 <= val <= 231 - 1
        最多调用 insert、remove 和 getRandom 函数 2 * 105 次
        在调用 getRandom 方法时，数据结构中 至少存在一个 元素。*/
public class 插入删除和获取随机元素 {

    /* 方法一：变长数组 + 哈希表
   这道题要求实现一个类，满足插入、删除和获取随机元素操作的平均时间复杂度为 O(1)。

   变长数组可以在 O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1) 的时间内判断元素是否存在，因此不能在 O(1) 的时间内完成插入和删除操作。哈希表可以在 O(1) 的时间内完成插入和删除操作，但是由于无法根据下标定位到特定元素，因此不能在 O(1) 的时间内完成获取随机元素操作。为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1)，需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。

   插入操作时，首先判断 val 是否在哈希表中，如果已经存在则返回 false，如果不存在则插入 val，操作如下：

   在变长数组的末尾添加 val；

   在添加 val 之前的变长数组长度为 val 所在下标 index，将 val 和下标 index 存入哈希表；

   返回 true。

   删除操作时，首先判断 val 是否在哈希表中，如果不存在则返回 false，如果存在则删除 val，操作如下：

   从哈希表中获得 val 的下标 index；

   将变长数组的最后一个元素 last 移动到下标 index 处，在哈希表中将 last 的下标更新为 index；

   在变长数组中删除最后一个元素，在哈希表中删除 val；

   返回 true。

   删除操作的重点在于将变长数组的最后一个元素移动到待删除元素的下标处，然后删除变长数组的最后一个元素。该操作的时间复杂度是 O(1)，且可以保证在删除操作之后变长数组中的所有元素的下标都连续，方便插入操作和获取随机元素操作。

   获取随机元素操作时，由于变长数组中的所有元素的下标都连续，因此随机选取一个下标，返回变长数组中该下标处的元素。

   作者：力扣官方题解
   链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/solutions/1411578/o1-shi-jian-cha-ru-shan-chu-he-huo-qu-su-rlz2/
   来源：力扣（LeetCode）
   著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
        List<Integer> nums;
        Map<Integer, Integer> indices;
        Random random;

        public 插入删除和获取随机元素() {
            nums = new ArrayList<Integer>();
            indices = new HashMap<Integer, Integer>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            indices.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            indices.put(last, index);
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }

}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */