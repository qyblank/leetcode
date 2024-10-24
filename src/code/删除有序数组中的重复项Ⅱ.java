package code;
/*80. 删除有序数组中的重复项 II
        中等
        相关标签
        相关企业
        给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



        说明：

        为什么返回数值是整数，但输出的答案是数组呢？

        请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

        你可以想象内部操作如下:

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
        print(nums[i]);
        }


        示例 1：

        输入：nums = [1,1,1,2,2,3]
        输出：5, nums = [1,1,2,2,3]
        解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
        示例 2：

        输入：nums = [0,0,1,1,1,1,2,3,3]
        输出：7, nums = [0,0,1,1,2,3,3]
        解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。


        提示：

        1 <= nums.length <= 3 * 104
        -104 <= nums[i] <= 104
        nums 已按升序排列*/
public class 删除有序数组中的重复项Ⅱ {

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

    //双指针优化前指针为待插入位，后指针为i，判断后指针是否与前指针前两位相同，如果相同则时需要舍弃位，如果不同则时插入位
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int left = 2;
        int right = 2;
        while(right < n){
            if( nums[right]!= nums[left-2]){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
