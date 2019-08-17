package algorithm;

/**
 *   Z 字形变换
 *
 * @author xiangtch
 * @date 2019/7/19 10:18
 * @email xiangtiancheng@deepexi.com
 */
public class Convert {

    /*
    *   题目：将一个给定的字符串根据给定的行数，以从上往下，从左往右排进行 Z(N) 字形排列，比如输入字符串为 "LEETCODEISHIRING"，行数为 3 时
    *        排列如下：
    *           L   C   I   R
    *           E T O E S I I G
    *           E   D   H   N
    *        之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"
    *   示例 1：
    *       输入：s = "LEETCODEISHIRING", nums = 3
    *       输出： "LCIRETOESIIGEDHN"
    *   示例 2：
    *       输入： s = "LEETCODEISHIRING", numRows = 4
    *       输出： "LDREOEIIECIHNTSG"
    *       解释：
    *          L     D     R
    *          E   O E   I I
    *          E C   I H   N
    *          T     S     G
    * */

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

    /**
     *   对字符串 s 进行 Z 字形排列
     *
     * @param s
     * @param numRows
     * @return
     */
    private static String convert(String s, int numRows){
        // 计算转换后的列数
        int colTransfer = (s.length() / ((numRows - 1) * 2)) * (numRows - 1)
                + (s.length() % ((numRows - 1) * 2) > numRows ? (s.length() % ((numRows - 1) * 2) - numRows + 1)
                : s.length() % ((numRows - 1) * 2) == 0 ?  0 : 1);
        // 创建一个存放转换后的数组
        char[][] charArr = new char[numRows][colTransfer];
        // 遍历字符串，输出打印结果
        for (int i = 1; i < s.length() + 1; i++){
            // 计算变换后的打印行数
            int row = i % ((numRows - 1) * 2) > numRows ? i % ((numRows - 1) * 2) - (numRows - 1)
                    : i % ((numRows - 1) * 2) ;
            // 计算变换后的打印列数
            int col = (i / ((numRows - 1) * 2)) * (numRows - 1)
                    + (i % ((numRows - 1) * 2) > numRows ? (i % ((numRows - 1) * 2) - numRows + 1)
                    : i % ((numRows - 1) * 2) == 0 ?  0 : 1);
            charArr[row - 1][col - 1] = s.charAt(i);
        }
        // 输出转换后的字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            for (int j = 0; j < colTransfer; j++){
                stringBuilder.append(charArr[i][j]);
            }
        }
        return stringBuilder.toString();
    }
}
