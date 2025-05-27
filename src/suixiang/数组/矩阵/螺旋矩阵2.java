package suixiang.数组.矩阵;
/*59. 螺旋矩阵 II
    中等
            相关标签
    相关企业
    给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。



    示例 1：


    输入：n = 3
    输出：[[1,2,3],[8,9,4],[7,6,5]]
    示例 2：

    输入：n = 1
    输出：[[1]]
    https://leetcode.cn/problems/spiral-matrix-ii/description/*/

class Solution {
    public int[][] generateMatrix(int n) {
        //思路：模拟填充过程
        //设计函数，每次只填充一条边，填充完之后调用下一条边的填充逻辑
        //关键点：每条边以左闭右开填充，只剩中心一个空位需要特殊处理
        int[][] matrix = new int[n][n];
        matrix[0][0]= 1;
        int max=n*n;
        int num=1;

        xput(matrix,0,0,n-1,1,max);
        return matrix;
    }

    void xput(int[][] matrix,int x,int ystart,int ylen,int start,int nmax){
        int max=start+Math.abs(ylen)-1;
        if(max<start) max=start;
        if(ylen>=0){
            // System.out.println(max+"   "+start);
            for (int i = start,j=ystart; i <= max; i++,j++) {
                matrix[x][j]=i;
     /*           for (int[] ints : matrix) {
                    System.out.println(Arrays.toString(ints));
                }
                System.out.println("=======================");*/
            }

            if(max<nmax) yput(matrix,ystart+ylen,x,ylen,max+1,nmax);
        }else {
            for (int i = start,j=ystart; i <=max; i++,j--) {
                matrix[x][j]=i;
       /*         for (int[] ints : matrix) {
                    System.out.println(Arrays.toString(ints));
                }
                System.out.println("=======================");*/
            }

            if(max<nmax) yput(matrix,ystart+ylen,x,ylen,max+1,nmax);

        }
    }

    private void yput(int[][] matrix, int y, int xstart, int xlen, int start, int n) {
        int max=start+Math.abs(xlen)-1;
        if(xlen>=0){
            for (int i = start,j=xstart; i <= max; i++,j++) {
                matrix[j][y]=i;
      /*          for (int[] ints : matrix) {
                    System.out.println(Arrays.toString(ints));
                }
                System.out.println("=======================");*/
            }
            // System.out.println(max);
            if(max<n) xput(matrix,xstart+xlen,y,-xlen,max+1,n);
        }else {
            for (int i = start,j=xstart; i <=max; i++,j--) {
                matrix[j][y]=i;
        /*        System.out.println("x:"+j+"y:"+y+"i:"+i);
                for (int[] ints : matrix) {
                    System.out.println(Arrays.toString(ints));

                }
                System.out.println("=======================");*/
            }

            if(max<n) xput(matrix,xstart+xlen+1,y+1,-(xlen+2),max+1,n);

        }
    }
}
