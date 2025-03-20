class Solution {
    public boolean isPerfectSquare(int num) {
         //二分查找，找到一个数的平方为num为止，找到返回true，找不到返回false
         //关键点：
        //1.边界问题：该题左右边界是可排除边界，在每次比较之后，left或right变动时可为mid-1或mid+1
        int left = 1;
        int right = num;
        int mid=num/2;

        while (left<=right){
            int sq=mid*mid;
            if(sq==num) return true;
            if(sq>num||mid>46340){
                right=mid-1;
                mid=left+(right-left)/2;
            }else{
                left=mid+1;
                mid=left+(right-left)/2;
            }
        }

        return false;
    }
}