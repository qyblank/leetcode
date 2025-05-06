package suixiang.哈希.有效的字母异位词;

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


        提示：

        1 <= ransomNote.length, magazine.length <= 105
        ransomNote 和 magazine 由小写英文字母组成*/
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
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

   /* 作者：力扣官方题解
    链接：https://leetcode.cn/problems/ransom-note/solutions/1135839/shu-jin-xin-by-leetcode-solution-ji8a/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
}
