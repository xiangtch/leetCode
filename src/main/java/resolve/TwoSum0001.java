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
        int[] nums = new int[]{2, 7, 11, 15};
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
