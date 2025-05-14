package suixiang.滑动窗口;

import java.util.HashSet;
import java.util.Set;

/*package suixiang.字符串;
3. 无重复字符的最长子串
        已解答
        中等
        相关标签
        相关企业
        提示
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。



        示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


        提示：

        0 <= s.length <= 5 * 104
        s 由英文字母、数字、符号和空格组成
        https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/*/
public class 无重复字符的最长字串 {

    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        char[] ss = s.toCharArray();
        Set<Character> set = new HashSet<>();//去重
        int res = 0;//结果
        for(int left = 0, right = 0; right < s.length(); right++) {//每一轮右端点都扩一个。
            char ch = ss[right];//right指向的元素，也是当前要考虑的元素
            while(set.contains(ch)) {//set中有ch，则缩短左边界，同时从set集合出元素
                set.remove(ss[left]);
                left++;
            }
            set.add(ss[right]);//别忘。将当前元素加入。
            res = Math.max(res, right - left + 1);//计算当前不重复子串的长度。
        }
        return res;
    }
}
