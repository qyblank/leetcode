package suixiang.动态规划;
/*
118. 杨辉三角
        已解答
简单
        相关标签
premium lock icon
        相关企业
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

在「杨辉三角」中，每个数是它左上方和右上方的数的和。





示例 1:

输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:

输入: numRows = 1
输出: [[1]]
*/

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> integers = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                //当j=0或者j=i的时候，都是1
               if(j==0||j==i){
                   integers.add(1);
               }else {
                   integers.add(lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
               }
            }
            lists.add(integers);
        }
        return lists;
    }
}
