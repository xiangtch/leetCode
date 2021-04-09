package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/4/7 22:29
 */
public class FourSum {

    /*
    *    题目：四数之和
    *    给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d，使得 a+b+c+d 的值与 target 相等？
    * 找出所有满足条件且不重复的四元组
    *    示例 1：
    *       输入：nums = [1,0,-1,0,-2,2], target = 0
    *       输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    *    示例 2：
    *       输入：nums = [], target = 0
    *       输出：[]
    */

    public static void main(String[] args) {
        System.out.println(findFourSum(new int[]{1,0,-1,0,-2,2}, 0));
        System.out.println(findFourSum(new int[]{}, 0));
    }

    private static List<List<Integer>> findFourSum(int[] nums, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();
        int minLength = 4;
        if (nums == null || nums.length < minLength) {
            return fourSumList;
        }
        Arrays.sort(nums);
        int minFirstIndexAwayEnd = 3;
        for (int i = 0; i < nums.length - minFirstIndexAwayEnd; i++){
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            int minSecondIndexAwayEnd = 2;
            for (int j = i + 1; j < nums.length - minSecondIndexAwayEnd; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        fourSumList.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return fourSumList;
    }

}
