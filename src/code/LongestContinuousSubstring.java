package code;/*
2414. 最长的字母序连续子字符串的长度
        中等
        相关标签
        相关企业
        提示
        字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。

        例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
        给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。



        示例 1：

        输入：s = "abacaba"
        输出：2
        解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
        "ab" 是最长的字母序连续子字符串。
        示例 2：

        输入：s = "abcde"
        输出：5
        解释："abcde" 是最长的字母序连续子字符串。


        提示：

        1 <= s.length <= 105
        s 由小写英文字母组成


*/

public class LongestContinuousSubstring {
    public int longestContinuousSubstring1(String s) {

        //将String转换成char数组能有效减少时间复杂度
          int len1=0,len2=0;//f,b为最长子字符串片段。f1,b1为当前正在判断的子字符串片段。len为最长子字符串长

        for (int i = 0; i < s.length(); i++) {

            if(i==s.length()-1){//，或读到字符串末尾时
                if(len2>len1) len1=len2;
                break;
            }

            if(s.charAt(i)-s.charAt(i+1)!=-1){//当遇到非连续字母更新当前子字符串，同时判断最长子字符串是否改变
                if(len2>len1) len1=len2;
                len2=1;
            }else {
                len2++;
            }
        }

        return len1+1;
    }
}
