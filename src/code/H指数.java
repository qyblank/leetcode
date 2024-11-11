package code;

import java.util.Arrays;

/*274. H 指数
        中等
        相关标签
        相关企业
        提示
        给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。

        根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。



        示例 1：

        输入：citations = [3,0,6,1,5]
        输出：3
        解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
        由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
        示例 2：

        输入：citations = [1,3,1]
        输出：1


        提示：

        n == citations.length
        1 <= n <= 5000
        0 <= citations[i] <= 1000*/
public class H指数 {
    public int hIndex(int[] citations) {
        //思路：将nums进行排序，设置a=length/2开始判断，h=len-a
        // 1.如果len-a>nums[h]，则h太大不符合条件，a向右移动一位，直到h<=nums[h]为止
        //2.如果len-a<nums[h],则h还有可能有更大值,a向左移动一位，直到h<=nums[h]为止
        if(citations==null||citations.length==0) return 0;
        if(citations.length==1&&citations[0]>=1) return 1;
        if(citations.length==1) return 0;

        int len=citations.length;
        int a=citations.length/2;
        int h=citations.length/2+1;
        //排序
        Arrays.sort(citations);

        //时间复杂度O(log n) 排序时间复杂的：O(nlog n)该算法时间复杂度由排序算法决定
        while(true){
            //System.out.println(h);
            if(h>citations[a]) {
                a++;//a向右移动
                h=len-a;
                if(a>=len) return 0;
                if(a<0) return len;
            }else {
                a--;
                h=len-a;
                if(a>=len) return 0;
                if(a<0) return len;
                if(h>citations[a]) return h-1;
            }
        }
    }

    public int hIndexBetter(int[] citations) {
        //思路：代码逻辑的详细解释：
        //
        //当我们从后往前累加cnt数组时，我们实际上是在检查有多少篇论文的引用次数至少是当前的i。
        //如果在某一次累加后，累加的数量s大于等于当前的引用次数i，那么就找到了一个满足条件的H指数。
        //由于我们是倒序遍历的，所以找到的第一个满足条件的i就是最大的H指数。
        //例如，对于输入citations = [3,0,6,1,5]：
        //
        //cnt数组将会是[0, 1, 1, 0, 1, 1]，表示0篇论文被引用0次，1篇论文被引用1次，1篇论文被引用2次，0篇论文被引用3次，1篇论文被引用4次，1篇论文被引用5次或以上。
        //从后往前累加，当i=3时，s为cnt[3]+cnt[4]+cnt[5] = 0+1+1 = 2，不满足条件。
        //当i=2时，s为cnt[2]+cnt[3]+cnt[4]+cnt[5] = 1+0+1+1 = 3，满足条件，因此返回i=2作为H指数。
        //这个算法的时间复杂度是O(n)，空间复杂度也是O(n)，因为它需要额外的数组来存储引用次数的分布。
        int n = citations.length;
        int[] cnt = new int[n+1];//每个下标都是存储相应条件的论文数量
        for(int c : citations){
            cnt[Math.min(c,n)]++;//cet[]中cet[n]用来计数nums中大于论文的有多少，其它下标计数nums等于下标的有多少
        }
        int s = 0;
        for(int  i = n; ; i--){//从cnt末尾开始遍历，cnt[n]的论文必定满足条件
            s+=cnt[i];//累计满足条件的论文数量
            if(s>=i) return i;//当论文引用数小于论文数时，找到h
        }
    }
}
