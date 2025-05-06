package suixiang.字符串;
/*541. 反转字符串 II
        简单
        相关标签
        相关企业
        给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

        如果剩余字符少于 k 个，则将剩余字符全部反转。
        如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


        示例 1：

        输入：s = "abcdefg", k = 2
        输出："bacdfeg"
        示例 2：

        输入：s = "abcd", k = 2
        输出："bacd"


        提示：

        1 <= s.length <= 104
        s 仅由小写英文组成
        1 <= k <= 104*/
public class 反转字符串2 {
    public String reverseStr(String s, int k) {
        char[] ss = s.toCharArray();
        char t=' ';
        for (int num= ss.length,start=0;num>0;){
            if(num>=2*k){
                for(int left=start,right=start+k-1;left<right;left++,right--){
                    t=ss[left];
                    ss[left]=ss[right];
                    ss[right]=t;
                }
                num-=2*k;
                start+=2*k;
            }else if(num<k){
                for(int left=start,right=start+num-1;left<right;left++,right--){
                    t=ss[left];
                    ss[left]=ss[right];
                    ss[right]=t;
                }
                break;
            }else{
                for(int left=start,right=start+k-1;left<right;left++,right--){
                    t=ss[left];
                    ss[left]=ss[right];
                    ss[right]=t;
                }
                break;
            }
        }
        return new String(ss);
    }
}
