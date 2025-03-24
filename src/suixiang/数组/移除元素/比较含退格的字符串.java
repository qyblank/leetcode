package suixiang.数组.移除元素;

/*844. 比较含退格的字符串
        简单
        相关标签
        相关企业
        给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。

        注意：如果对空文本输入退格字符，文本继续为空
        https://leetcode.cn/problems/backspace-string-compare/description/*/
public class 比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        //思路：
        //双指针
        //思路及算法
        //
        //一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
        //
        //具体地，我们定义 skip 表示当前待删除的字符的数量。每次我们遍历到一个字符：
        //
        //若该字符为退格符，则我们需要多删除一个普通字符，我们让 skip 加 1；
        //
        //若该字符为普通字符：
        //
        //若 skip 为 0，则说明当前字符不需要删去；
        //
        //若 skip 不为 0，则说明当前字符需要删去，我们让 skip 减 1。
        //
        //这样，我们定义两个指针，分别指向两字符串的末尾。每次我们让两指针逆序地遍历两字符串，直到两字符串能够各自确定一个字符，然后将这两个字符进行比较。重复这一过程直到找到的两个字符不相等，或遍历完字符串为止。
        int ps=s.length()-1,pt=t.length()-1;
        int skips=0,skipt=0;

        while(ps>=0||pt>=0){

            //找s中的倒数第一个字符
            while(ps>=0){
                if(s.charAt(ps)=='#'){
                    ps--;
                    skips++;
                    continue;
                }else if(skips==0) break;
                skips--;
                ps--;
            }

            //找t中的倒数第一个字符
            while(pt>=0){
                if(t.charAt(pt)=='#'){
                    pt--;
                    skipt++;
                    continue;
                }else if(skipt==0) break;
                skipt--;
                pt--;
            }
            System.out.println(ps+" "+pt);
            if(ps>=0&&pt>=0){
                //都有有字符且字符不一样返回false
                if(s.charAt(ps)!=t.charAt(pt)) return false;
            }else {
                //有一个没有字符返回false
                if(ps>=0||pt>=0) return false;
            }
            ps--;
            pt--;
        }
        return true;
    }

}
