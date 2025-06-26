package suixiang.多维动态规划;

public class 最长回文子串 {
/*5. 最长回文子串
            已解答
    中等
            相关标签
    premium lock icon
            相关企业
    提示
    给你一个字符串 s，找到 s 中最长的 回文 子串。



    示例 1：

    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：

    输入：s = "cbbd"
    输出："bb"


    提示：

            1 <= s.length <= 1000
    s 仅由数字和英文字母组成*/
    public String longestPalindrome(String s) {
        int[] ans=new int[2];
        int len=0;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];

        //设置初始值
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for (int L = 2; L < n; L++) {
            for (int i = 0; i < n; i++) {
                int j=i+L-1;
                if(j>=n) {
                    break;
                }
                if(s.charAt(i)==s.charAt(j)){
                    if(L==2){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if(dp[i][j]&&L>len){
                    len=L;
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }

        return s.substring(ans[0],ans[1]+1);
    }

    public static void main(String[] args) {
        String s="bb";
        System.out.println(new 最长回文子串().longestPalindrome(s));
    }
}
