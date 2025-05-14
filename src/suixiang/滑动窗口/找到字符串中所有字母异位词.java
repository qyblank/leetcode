package suixiang.滑动窗口;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到字符串中所有字母异位词 {
  /*  方法一：滑动窗口
    根据题目要求，我们需要在字符串 s 寻找字符串 p 的异位词。因为字符串 p 的异位词的长度一定与字符串 p 的长度相同，所以我们可以在字符串 s 中构造一个长度为与字符串 p 的长度相同的滑动窗口，并在滑动中维护窗口中每种字母的数量；当窗口中每种字母的数量与字符串 p 中每种字母的数量相同时，则说明当前窗口为字符串 p 的异位词。

    算法
    在算法的实现中，我们可以使用数组来存储字符串 p 和滑动窗口中每种字母的数量。

    细节
    当字符串 s 的长度小于字符串 p 的长度时，字符串 s 中一定不存在字符串 p 的异位词。但是因为字符串 s 中无法构造长度与字符串 p 的长度相同的窗口，所以这种情况需要单独处理。

    方法二：优化的滑动窗口
            思路和算法
    在方法一的基础上，我们不再分别统计滑动窗口和字符串 p 中每种字母的数量，而是统计滑动窗口和字符串 p 中每种字母数量的差；并引入变量 differ 来记录当前窗口与字符串 p 中数量不同的字母的个数，并在滑动窗口的过程中维护它。

    在判断滑动窗口中每种字母的数量与字符串 p 中每种字母的数量是否相同时，只需要判断 differ 是否为零即可。

    作者：力扣官方题解
    链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string/solutions/1123971/zhao-dao-zi-fu-chuan-zhong-suo-you-zi-mu-xzin/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
    public List<Integer> findAnagrams(String s, String p) {

        if(s.isEmpty()||s.length()<p.length()) return new ArrayList<>();

        List<Integer> res=new ArrayList<>();

        int[] count=new int[26];
        int sl=s.length(),pl=p.length();

        //使用一个数组来记录初始滑动窗口中和p中不同字符的个数，count[char]不为0则该字符存在不一致
        for (int i = 0; i < pl; i++) {
            ++count[s.charAt(i)-'a'];
            --count[p.charAt(i)-'a'];
        }

        //统计不一致的字符个数
        int buffer=0;
        for (int i = 0; i < 26; i++) {
            if(count[i]!=0) {
                buffer++;
            }
        }
        //细节 判断第一个滑动窗口是否符合要求
        if(buffer==0) {
            res.add(0);
        }
        for (int i = 0; i <sl-pl ; i++) {

            //滑动窗口每出一个字符进行判断
            if(count[s.charAt(i)-'a']==1) {//如果出的字符正好多余一个则不一致字符数减一
                buffer--;
            }else if(count[s.charAt(i)-'a']==0){
                buffer++;
            }
            --count[s.charAt(i)-'a'];

            //滑动窗口每进一个字符进行判断
            if(count[s.charAt(i+pl)-'a']==-1){
                buffer--;
            }else  if(count[s.charAt(i+pl)-'a']==0){
                buffer++;
            }
            ++count[s.charAt(i+pl)-'a'];

            if(buffer==0) {//不一致字符数为零，说明该滑动窗口符合要求
                res.add(i+1);
            }
        }
        return res;
    }

}
