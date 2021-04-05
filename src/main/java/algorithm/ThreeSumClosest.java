package algorithm;

/**
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/4/5 21:46
 */
public class ThreeSumClosest {

    /*
    *    题目：最接近的三数之和(可先排序)
    *    给定一个包括 n 个整数的数组 nums 和一个目标值 target。找出 nums 中的三个整数，使得他们的和与 target 最接近。返回这三个数的和。假定
    * 每组输入只存在唯一答案。
    *    示例：
    *       输入：nums = [-1,2,1,-4], target = 1
    *       输出：2
    *       解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
    */

    public static void main(String[] args) {
        System.out.println(findThreeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    private static Integer findThreeSumClosest(int[] nums, int target) {
        int closest = 10000;
        int targetSum = 0;
        for (int first = 0; first < nums.length; first++) {
            for (int second = first + 1; second < nums.length; second++) {
                for (int third = second + 1; third < nums.length; third++) {
                   int abs = Math.abs(nums[first] + nums[second] + nums[third] - target);
                   if (abs < closest) {
                       closest = abs;
                       targetSum = nums[first] + nums[second] + nums[third];
                   }
                }
            }
        }
        return targetSum;
    }
}
