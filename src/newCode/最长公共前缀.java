package newCode;
/*
4. 最长公共前缀
        已解答
        简单
        相关标签
        相关企业
        编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。



        示例 1：

        输入：strs = ["flower","flow","flight"]
        输出："fl"
        示例 2：

        输入：strs = ["dog","racecar","car"]
        输出：""
        解释：输入不存在公共前缀。
*/

public class 最长公共前缀 {


  /*  算法分析：

    初始化：
    首先检查输入数组是否为空或长度为0，如果是，则直接返回空字符串。
    找到所有字符串中的最小长度，因为公共前缀的长度不会超过最短字符串的长度。
    二分查找：
    使用二分查找来确定最长公共前缀的长度。设置low为1（公共前缀至少为1个字符），high为最短字符串的长度。
    在low小于等于high的条件下，计算中间值mid，并检查从第一个字符串中取出的长度为mid的前缀是否是所有字符串的公共前缀。
    检查公共前缀：
    isCommonPrefix方法检查长度为mid的前缀是否是所有字符串的公共前缀。如果是，则增加low，否则减少high。
    返回结果：
    当二分查找结束时，(low + high) / 2将是公共前缀的最大长度。使用这个长度从第一个字符串中截取子串并返回。*/
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) return "";

            int minLen = Integer.MAX_VALUE;
            for (String str : strs) {
                minLen = Math.min(minLen, str.length());
            }

            int low = 1;
            int high = minLen;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (isCommonPrefix(strs, mid)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return strs[0].substring(0, (low + high) / 2);
        }

        private boolean isCommonPrefix(String[] strs, int len) {
            String prefix = strs[0].substring(0, len);
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(prefix)) {
                    return false;
                }
            }
            return true;
        }


}
