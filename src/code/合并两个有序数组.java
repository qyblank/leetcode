/*
88. 合并两个有序数组
        简单
        相关标签
        相关企业
        提示
        给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。

        请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。

        注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。



        示例 1：

        输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        输出：[1,2,2,3,5,6]
        解释：需要合并 [1,2,3] 和 [2,5,6] 。
        合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
        示例 2：

        输入：nums1 = [1], m = 1, nums2 = [], n = 0
        输出：[1]
        解释：需要合并 [1] 和 [] 。
        合并结果是 [1] 。
        示例 3：

        输入：nums1 = [0], m = 0, nums2 = [1], n = 1
        输出：[1]
        解释：需要合并的数组是 [] 和 [1] 。
        合并结果是 [1] 。
        注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。


        提示：

        nums1.length == m + n
        nums2.length == n
        0 <= m, n <= 200
        1 <= m + n <= 200
        -109 <= nums1[i], nums2[j] <= 109


        进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
*/



package code;

public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //基本思路：在两个数组中寻找最大值，依次从nums1后插入
        for (int i1=m-1 ,i2= n-1,i=nums1.length-1;i>=0 ;) {//i1指向nums1最大值，i2指向nums2最大值,i指向当前应插入的nums1的位置
            if(i1<0){//如果nums1遍历完成，直接将nums2中元素插入到nums1前
                for (int j = 0; j <=i2; j++) {
                    nums1[j]=nums2[j];
                }
                break;
            }
            if(i2<0){//如果nums2遍历完成，直接退出
                break;
            }
            if(nums1[i1]>=nums2[i2]){
                nums1[i]=nums1[i1];
                i1--;
                i--;
                continue;
            } else if (nums1[i1]<nums2[i2]) {
                nums1[i]=nums2[i2];
                i2--;
                i--;
                continue;
            }

        }
    }

}
