package resolve;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/4/13 16:04
 */
public class FindMedianSortedArrays0004 {

    public static void main(String[] args) {
        /*
        * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 num1 和 num2。请你找出并返回这两个正序数组的中位数
        * 算法的时间复杂度为 O(log(m+n))
        *
        * 分治，二分查找
        *
        * */
        System.out.println(findMedianSortedArray(new int[]{1, 4}, new int[]{2, 3}));
    }

    private static Double findMedianSortedArray(int[] num1, int[] num2) {
        int m = num1.length;
        int n = num2.length;
        // 中位数左边的数位置索引
        int leftIndex = (m + n - 1) / 2;
        // 中位数右边的数位置索引
        int rightIndex = (m + n) / 2;
        // i num1 的起始位置，j num2 的起始位置
        return (findKth(num1, 0, num2, 0, leftIndex) + findKth(num1, 0, num2, 0, rightIndex)) / 2.0;
    }

    private static int findKth(int[] num1, int num1StartIndex, int[] num2, int num2StartIndex, int nearMiddleIndex) {
        if (num1StartIndex >= num1.length) {
            return num2[num2StartIndex + nearMiddleIndex];
        }
        if (num2StartIndex >= num2.length) {
            return num1[num1StartIndex + nearMiddleIndex];
        }
        if (nearMiddleIndex == 0) {
            return Math.min(num1[num1StartIndex], num2[num2StartIndex]);
        }
        int midVal1 = (num1StartIndex + nearMiddleIndex / 2  < num1.length) ? num1[num1StartIndex + nearMiddleIndex / 2] : Integer.MAX_VALUE;
        int mindVal2 = (num2StartIndex + nearMiddleIndex / 2 < num2.length) ? num2[num2StartIndex + nearMiddleIndex / 2] : Integer.MAX_VALUE;
        // 移动 k/2 位
        if (midVal1 < mindVal2) {
            return findKth(num1, num1StartIndex + nearMiddleIndex  / 2 + 1, num2, num2StartIndex, nearMiddleIndex - nearMiddleIndex / 2 - 1);
        }
        return findKth(num1, num1StartIndex, num2, num2StartIndex + nearMiddleIndex / 2 + 1, nearMiddleIndex - nearMiddleIndex / 2 - 1);
    }
}
