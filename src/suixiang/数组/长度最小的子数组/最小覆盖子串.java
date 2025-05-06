package suixiang.数组.长度最小的子数组;

import java.util.HashMap;
import java.util.Map;

/*76. 最小覆盖子串
        困难
        相关标签
        相关企业
        提示
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。



        注意：

        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
        如果 s 中存在这样的子串，我们保证它是唯一的答案。


        示例 1：

        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
        示例 2：

        输入：s = "a", t = "a"
        输出："a"
        解释：整个字符串 s 是最小覆盖子串。
        示例 3:

        输入: s = "a", t = "aa"
        输出: ""
        解释: t 中两个字符 'a' 均应包含在 s 的子串中，
        因此没有符合条件的子字符串，返回空字符串。
        https://leetcode.cn/problems/minimum-window-substring/description/*/
public class 最小覆盖子串 {
/*    方法一：滑动窗口
            思路和算法

    本问题要求我们返回字符串 s 中包含字符串 t 的全部字符的最小窗口。我们称包含 t 的全部字母的窗口为「可行」窗口。

    我们可以用滑动窗口的思想解决这个问题。在滑动窗口类型的问题中都会有两个指针，一个用于「延伸」现有窗口的 r 指针，和一个用于「收缩」窗口的 l 指针。在任意时刻，只有一个指针运动，而另一个保持静止。我们在 s 上滑动窗口，通过移动 r 指针不断扩张窗口。当窗口包含 t 全部所需的字符后，如果能收缩，我们就收缩窗口直到得到最小窗口。



    如何判断当前的窗口包含所有 t 所需的字符呢？我们可以用一个哈希表表示 t 中所有的字符以及它们的个数，用一个哈希表动态维护窗口中所有的字符以及它们的个数，如果这个动态表中包含 t 的哈希表中的所有字符，并且对应的个数都不小于 t 的哈希表中各个字符的个数，那么当前的窗口是「可行」的。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/minimum-window-substring/solutions/257359/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/

    public String minWindow(String s, String t) {

        Map<Character,Integer> tmap=new HashMap<>();
        Map<Character,Integer> wmap=new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int l=0,r=0;
        int len=Integer.MAX_VALUE,ansl=-1,asnr=-1;
        int slen=s.length();

        while(r<slen){

            char scr= s.charAt(r);
            //System.out.println(tmap.getOrDefault(scr, 0));
            wmap.put(scr, wmap.getOrDefault(scr, 0) + 1);

            //  System.out.println(wmap);
            while(iscontain(tmap,wmap)){
                char scl=s.charAt(l);
                int newlen=r-l+1;
                if(len>newlen){
                    len=newlen;
                    ansl=l;
                    asnr=r;
                }
                l++;
              /*  System.out.println(wmap);
                System.out.println(tmap);*/

                wmap.put(scl,wmap.getOrDefault(scl,0)-1);
             /*   System.out.println(wmap);
                System.out.println("-----------------------------------");*/
            }
            ++r;
        }
        return len==Integer.MAX_VALUE?"":s.substring(ansl,asnr+1);
    }

    private boolean iscontain(Map<Character, Integer> tmap, Map<Character, Integer> wmap) {

        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if(entry.getValue()>wmap.getOrDefault(entry.getKey(),0)) return false;
        }
        return true;
    }
}
