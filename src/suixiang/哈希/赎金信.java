package suixiang.哈希;

import java.util.HashMap;
import java.util.Map;

/*383. 赎金信
        简单
        相关标签
        相关企业
        给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

        如果可以，返回 true ；否则返回 false 。

        magazine 中的每个字符只能在 ransomNote 中使用一次。



        示例 1：

        输入：ransomNote = "a", magazine = "b"
        输出：false
        示例 2：

        输入：ransomNote = "aa", magazine = "ab"
        输出：false
        示例 3：

        输入：ransomNote = "aa", magazine = "aab"
        输出：true
        https://leetcode.cn/problems/ransom-note/description/*/
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        //思路一：
        //使用hashmap来存储magazine中出现的元素个数
        Map<Character,Integer> mmap=new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            mmap.put(c, mmap.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if(mmap.get(c)==null||mmap.get(c)<=0) return false;
            mmap.put(c,mmap.get(c)-1);
        }
        return true;
    }

    //思路二：
    //使用字符数组存储magazine中元素出现的个数
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
