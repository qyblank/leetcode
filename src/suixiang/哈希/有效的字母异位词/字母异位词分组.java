package suixiang.哈希.有效的字母异位词;

import java.lang.invoke.CallSite;
import java.util.*;
/*49. 字母异位词分组
        已解答
        中等
        相关标签
        相关企业
        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

        字母异位词 是由重新排列源单词的所有字母得到的一个新单词。



        示例 1:

        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        示例 2:

        输入: strs = [""]
        输出: [[""]]
        示例 3:

        输入: strs = ["a"]
        输出: [["a"]]


        提示：

        1 <= strs.length <= 104
        0 <= strs[i].length <= 100
        strs[i] 仅包含小写字母
        https://leetcode.cn/problems/group-anagrams/description/*/
public class 字母异位词分组 {
/*
    两个字符串互为字母异位词，当且仅当两个字符串包含的字母相同。同一组字母异位词中的字符串具备相同点，可以使用相同点作为一组字母异位词的标志，使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。

    遍历每个字符串，对于每个字符串，得到该字符串所在的一组字母异位词的标志，将当前字符串加入该组字母异位词的列表中。遍历全部字符串之后，哈希表中的每个键值对即为一组字母异位词。

    以下的两种方法分别使用排序和计数作为哈希表的键。

    方法一：排序
    由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
*/
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> m=new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            //getOrDefault
            List<String> list = m.getOrDefault(s, new ArrayList<String>());
            list.add(strs[i]);
            m.put(s, list);
        }
       return new ArrayList<>(m.values());
    }
}
