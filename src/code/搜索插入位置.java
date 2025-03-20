package code;

/*35. 搜索插入位置
        简单
        相关标签
        相关企业
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

        请必须使用时间复杂度为 O(log n) 的算法。*/



public class 搜索插入位置 {


        public int searchInsert(int[] nums, int target) {
            //二分查找
            int left=0,right=nums.length-1;

            while(left<=right){
                int mid=(left+right)/2;//int mid = ((right - left) >> 1) + left;左移效率更高
                if(nums[mid]<target){
                    left=mid+1;
                }
                else{
                    right=mid-1;
                }
            }
            return left;
        }

}
