package algorithm;

/**
 *   寻找两个有序数组的中位数
 *
 * @author xiangtch
 * @date 2019/7/18 15:01
 * @email xiangtiancheng@deepexi.com
 */
public class FindMedianSortedArrays {

    /*
    *  题目： 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2，请你找出有序数组中的中位数，并且要求算法的时间复杂度为 O(log(m+n))
    *        你可以假设 nums1 和 nums2 不能同时为空
    *  示例 1：
    *       nums1 = [1, 3]
    *       nums2 = [2]
    *       则中位数为 2.0
    *  示例 2：
    *       nums1 = [1, 2]
    *       nums2 = [3, 4]
    *       则中位数为 (2 + 3) / 2 = 2.5
    * */

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        Double median = findFindMedianSortedArrays(nums1, nums2);
        System.out.println(median);
        int[] nums3 = new int[]{1, 2};
        int[] nums4 = new int[]{3, 4};
        Double median2 = findFindMedianSortedArrays(nums3, nums4);
        System.out.println(median2);
    }

    /**
     *   找到两个有序数组的中位数，算法时间复杂度为 O(log(m+n))
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private static Double findFindMedianSortedArrays(int[] nums1, int[] nums2) {
        // 比较 nums1 和 nums2 的最大值，决定遍历的顺序
        return  nums2.length < 1 || (nums1.length > 0 && nums1[nums1.length - 1] > nums2[nums2.length - 1]) ? findMedian(nums1, nums2) : findMedian(nums2, nums1);
    }

    private static Double findMedian(int[] outer, int[] inner) {
        // 判断中位数是一个数还是两个数的均值
        boolean isExist = ((outer.length + inner.length) & 1) != 0;
        // 计算中位数开始的位置
        int medianIndex = (outer.length + inner.length) >> 1;
        // 记录查找的合并数组的位置
        int findIndex = 0;
        // 遍历两个有序数组，合并成一个有序数组
        int[] findArr = new int[medianIndex + 1];
        for (int i = 0; i < outer.length; i++){
            for (int j = findIndex - i; j < inner.length; j++){
                if (outer[i] < inner[j]){
                    break;
                }
                // 如果 inner 的元素小于 outer 的元素，则将 inner 的元素放进 findArr 中
                findArr[findIndex] = inner[j];
                // 判断 findIndex 是否达到 findIndex 的边界
                if (findIndex == medianIndex){
                    return isExist ? findArr[findIndex] : (findArr[findIndex] + findArr[findIndex - 1]) / 2.0;
                }
                findIndex++;
            }
            findArr[findIndex] = outer[i];
            // 判断 findIndex 是否达到 findIndex 的边界
            if (findIndex == medianIndex){
                return isExist ? findArr[findIndex] : (findArr[findIndex] + findArr[findIndex - 1]) / 2.0;
            }
            findIndex++;
        }
        throw new RuntimeException("未知错误");
    }
}
