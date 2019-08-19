package algorithm;

/**
 * @author xiangtch
 * @date 2019/8/19 11:47
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class Reverse {

    /*
    *   给出一个 32 位有符号的整数，你需要将这个整数中每位上的数字进行反转。
    *
    *   示例1：
    *      输入： 123
    *      输出： 321
    *   示例2：
    *      输入： -123
    *      输出： -321
    *   示例3：
    *      输入： 120
    *      输出： 21
    *   注意：
    *     假设环境只能存储的下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
    *
    * */

    public static void main(String[] args) {
        System.out.println(findReverse(123));
        System.out.println(findReverse(-123));
        System.out.println(findReverse(120));
    }

    /**
     *   将 int 类型的数进行反转
     *
     * @param x
     * @return
     */
    private static int findReverse(int x) {
        // 存储反转后的值
        long reverse = 0L;
        // 存储余数
        int remainder = 0;
        // 存储 x 的符号
        boolean flag = x < 0;
        x = Math.abs(x);
        while (x != 0){
            remainder = x % 10;
            reverse = reverse * 10 + remainder;
            x = x / 10;
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
            return 0;
        }
        if (flag){
            return (int)(-reverse);
        }else {
            return (int)reverse;
        }
    }
}
