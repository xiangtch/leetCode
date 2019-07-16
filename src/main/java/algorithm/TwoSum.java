package algorithm;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangtch
 * @date 2019/7/17 0:42
 * @email xiangtch6@gmail.com
 */
public class TwoSum {
    /*
    *  题目：给定一个整数数组 nums 和一个目标值 target，请你在数组中找出和为目标值的那两个整数，并返回他们的数组下标
    *
    *  可以假设每种输入只会对应一个答案，但是不能重复利用数组中同样的元素
    *
    *  示例：
    *    给定 nums = [2, 7, 11, 15]，target = 9
    *    因为 num[0] + num[1] = 2 + 7 = 9，
    *    所以返回 [0, 1]
    *
    * */

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] indexArr = findTwoSum(nums, target);
        System.out.println(new Gson().toJson(indexArr));
    }

    private static int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            // 将数组映射到 hashMap 中， key 为数组元素的值，value 为索引的值
            hashMap.put(nums[i], i);
        }
        // 遍历数组元素，判断该元素以及其对应的另外一个元素在 hashMap 上是否有值
        for (int i = 0; i < nums.length; i++){
            // 计算出另外一个元素
            int t = target - nums[i];
            // hashMap 中包含；另外一个元素且这两个元素不为同一个元素
            if (hashMap.containsKey(t) && hashMap.get(t) != i){
                return new int[]{i, hashMap.get(t)};
            }
        }
        throw new RuntimeException("没有符合的两个元素的组合！");
    }
}
