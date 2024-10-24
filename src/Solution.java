import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
         //思路：在去除重复元素的基础上添加一个计数器，记录重复次数，当计数器超过二是才进行补位操作
        if(nums.length==0) return 0;
        int count=0;//计数器
        int t=0;//待插入位
        int f=nums[0];//比较位
        int num=0;//总数

        for (int i = 0; i <nums.length ; i++) {

            if(f!=nums[i]){//当出现了新元素时必定需要将该元素计入至去重后的数组，直接进行插入兵重置各值

                    nums[t]=nums[i];
                    count=1;//conunt发现新元素时从1开始
                    t++;
                    f=nums[i];
                    num++;
            }else {
                if(count!=2){//当没有出现新元素但是与f相同元素不超过2时，该元素也应当被插入，并将重置各值
                    nums[t]=nums[i];
                    count++;
                    t++;
                    num++;
                }
            }
        }

        return num;
    }
}