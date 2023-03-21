package algorithm;

/**
 * @author xiangtch
 * @date 2019/8/19 19:46
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class MyAtoi {

    /*
    *   将字符串转换为整数
    *   首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。当我们寻找到的第一个非空字符为正或者负号时，
    * 则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，
    * 形成整数。该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
    *   注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
    * 在任何情况下，若函数不能进行有效的转换时，请返回 0，超过 int 范围的返回 Integer.MAX_VALUE 或 Integer.MIN_VALUE
    *   示例1：
    *     输入： "42"
    *     输出： 42
    *   示例2：
    *     输入："    -42"
    *     输出：-42
    *   示例3：
    *     输入："4193 with words"
    *     输出：4193
    *   示例4：
    *     输入："words and 987"
    *     输出：0
    *   示例5：
    *     输入："-91283472332"
    *     输出：-2147483648
    *
    * */

    public static void main(String[] args) {
        System.out.println(findMyAtoi("42"));
        System.out.println(findMyAtoi("   -42"));
        System.out.println(findMyAtoi("4193 with words"));
        System.out.println(findMyAtoi("words and 987"));
        System.out.println(findMyAtoi("-91283472332"));
        System.out.println(findMyAtoi("9223372036854775808"));
        System.out.println(findMyAtoi("+1"));
    }

    /**
     *   字符串转整数
     *
     * @param str
     * @return
     */
    private static int findMyAtoi(String str) {
        // 存储截取的整数
        long num = 0L;
        // 存储符号标志，默认为正数
        boolean sign = true;
        // 存储符号位标记
        boolean signFlag = true;
        // 开头连续空格标记，默认为 false
        boolean blankFlag = true;
        // 遍历字符串，截取整数部分
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' '){
                blankFlag = false;
            }
            // 如果开头连续为空，继续迭代
            if (blankFlag){
                continue;
            }
            // 判断是否为符号位标记，且标记符号位 -
            if (signFlag && str.charAt(i) == '-'){
                // 找到标记位后，后面出现的为字符，不为标记符号
                signFlag = false;
                sign = false;
                continue;
            }
            // 判断是否为符号位标记，且标记符号位 -
            if (signFlag && str.charAt(i) == '+'){
                // 找到标记位后，后面出现的为字符，不为标记符号
                signFlag = false;
                continue;
            }
            // 没找到标记位，就不用查找标记位，默认为正数
            signFlag = false;

            // 判断符号位后面是否为数字
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                num = num * 10 + str.charAt(i) - '0';
                if (num > Integer.MAX_VALUE){
                    break;
                }
            }else {
                break;
            }
        }
        // 输出结果
        if (num > Integer.MAX_VALUE && sign){
            return Integer.MAX_VALUE;
        }
        if (-num < Integer.MIN_VALUE && !sign){
            return Integer.MIN_VALUE;
        }
        return sign ? (int)num : (int)-num;
    }
}
