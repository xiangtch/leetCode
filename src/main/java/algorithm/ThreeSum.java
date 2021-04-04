package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/4/4 22:57
 */
public class ThreeSum {

    /*
    *    题目：三数之和
    *    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    *    注意：答案中不可以包含重复的三元组。
    *    示例 1：
    *       输入：nums = [-1,0,1,2,-1,-4]
    *       输出：[[-1,-1,2],[-1,0,1]]
    *    示例 2：
    *       输入：nums = []
    *       输出：[]
    *    示例 3：
    *       输入：nums = [0]
    *       输出：[]
    */

    public static void main(String[] args) {
        System.out.println(findThreeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(findThreeSum(new int[]{}));
        System.out.println(findThreeSum(new int[]{0}));
    }

    private static List<List<Integer>> findThreeSum(int[] nums) {
        int minLength = 3;
        if (nums.length < minLength) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; ++first) {
            // 移除重复元素
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > -nums[first]) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
