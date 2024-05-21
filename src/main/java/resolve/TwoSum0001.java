package resolve;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/3/22 9:29
 */
public class TwoSum0001 {

    public static void main(String[] args) {
        /*
        * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
        * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
        * */
        int[] nums = new int[]{2, 7, 11, 15};
        /*
        * 用哈希表（字典）存放数组值以及对应的下标。
        * 遍历数组，当发现 target - nums[i] 在哈希表中，说明找到了目标值
        * 时间复杂度O(n),空间复杂度O(n)。其中 n 是数组 nums 的长度
        * */
        System.out.println(new Gson().toJson(twoSum(nums, 9)));;
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int v = nums[i];
            int x = target - v;
            if (m.containsKey(x)) {
                return new int[]{m.get(x), i};
            }
            m.put(v, i);
        }
        return null;
    }
}
