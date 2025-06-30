package suixiang.动态规划;
/*279. 完全平方数
        中等
相关标签
premium lock icon
        相关企业
给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。



示例 1：

输入：n = 12
输出：3
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9

提示：

        1 <= n <= 104*/
public class 完全平方数 {
    public int numSquares(int n) {
        //我们可以依据题目的要求写出状态表达式：f[i] 表示最少需要多少个数的平方来表示整数 i。
        //
        //这些数必然落在区间 [1,根号i]中
        // 我们可以枚举这些数，假设当前枚举到 j，那么我们还需要取若干数的平方，构成 i−j
        // 。此时我们发现该子问题和原问题类似，只是规模变小了。这符合了动态规划的要求，于是我们可以写出状态转移方程。
        //
        //作者：力扣官方题解
        //链接：https://leetcode.cn/problems/perfect-squares/solutions/822940/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        int[] dp=new int[n+1];
        for (int i = 1; i <=n; i++) {
            int min=Integer.MAX_VALUE;
            for (int j = 1; j*j <= i ; j++) {

                min = Math.min(min, dp[i - j * j]);//状态转移方程：j*j是一个完全平方数，那么i-j*j这个数就可以从dp中找出他的最小值
            }
        }

        return dp[n];
    }
}
