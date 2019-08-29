package algorithm;

import java.util.HashMap;

/**
 *   整数转罗马数字
 *
 * @author xiangtch
 * @date 2019/8/29 15:16
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class IntoRoman {

    /*
    *   罗马数字包含以下七种字符：I，V，X，L，C，D 和 M
    *
    *   字符      数字
    *    I         1
    *    V         5
    *    X         10
    *    L         50
    *    C         100
    *    D         500
    *    M         1000
    *
    *   例如，罗马数字 2 写作 II，即为两个并列的 1。12 写作 XII，即为 X + II。27 写做 XXVII，即 XX + V + II。
    *   通常情况下，罗马数字中小的数字在打的数字的右边，但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
    *所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
    *   I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9
    *   X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
    *   C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
    *
    * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
    *
    *   示例1：
    *     输入：3
    *     输出："III"
    *   示例2：
    *     输入： 4
    *     输出： "IV"
    *   示例3：
    *     输入： 9
    *     输出： "IX"
    *   示例4：
    *     输入： 58
    *     输出： "LVIII"
    *   示例5：
    *     输入： 1994
    *     输出： "MCMXCIV"
    *     解释： M = 1000, CM = 900，XC = 90，IV = 4
    * */

    public static void main(String[] args) {
        System.out.println(findIntoRoman(3));
        System.out.println(findIntoRoman(4));
        System.out.println(findIntoRoman(9));
        System.out.println(findIntoRoman(58));
        System.out.println(findIntoRoman(1994));
    }

    /**
     *   整数转罗马数字
     *
     * @param num 数字 [1, 3999]
     * @return 罗马字符串
     */
    private static String findIntoRoman(int num) {
        // 限制数字大小
        if (num > 3999 || num < 1){
            throw new RuntimeException("输入的数字有误");
        }
        // 定义罗马数字与数字的映射关系
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] number = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        // 定义装换后的罗马数字
        StringBuilder sb = new StringBuilder();
        // 获取 num 对应的罗马数字的中能去的最大值的索引
        int index = 12;
        while (index >= 0) {
            while (num >= number[index]) {
                sb.append(roman[index]);
                num -= number[index];
            }
            index--;
        }
        return sb.toString();
    }
}
