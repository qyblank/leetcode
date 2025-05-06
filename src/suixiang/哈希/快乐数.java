package suixiang.哈希;

import java.util.HashSet;
/*202. 快乐数
        已解答
        简单
        相关标签
        相关企业
        编写一个算法来判断一个数 n 是不是快乐数。

        「快乐数」 定义为：

        对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
        然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
        如果这个过程 结果为 1，那么这个数就是快乐数。
        如果 n 是 快乐数 就返回 true ；不是，则返回 false 。



        示例 1：

        输入：n = 19
        输出：true
        解释：
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1
        示例 2：

        输入：n = 2
        输出：false


        提示：

        1 <= n <= 231 - 1
        https://leetcode.cn/problems/happy-number/description/*/
public class 快乐数 {

   /* 这道题目看上去貌似一道数学问题，其实并不是！

    题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现，这对解题很重要！

    正如：关于哈希表，你该了解这些！ (opens new window)中所说，当我们遇到了要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了。

    所以这道题目使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。

    判断sum是否重复出现就可以使用unordered_set。*/
    public boolean isHappy(int n) {

        int m=n;
        HashSet<Integer> nums =new HashSet<>();
        while(true){
            int sum=0;
            for (int i = 0;  m > 0  ; i++) {
                int a =m%10;
                sum+=a*a;
                m/=10;
            }
            if(sum==1) return true;
            if(nums.contains(sum)) return false;
            nums.add(sum);
            m=sum;
        }
    }
}
