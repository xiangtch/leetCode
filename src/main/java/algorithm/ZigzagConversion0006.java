package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2022/10/25 9:14
 */
public class ZigzagConversion0006 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();
        // 之字写法后的第一行的索引为 k * (2 * numRows - 2)
        // 第 numRows - 1 行的数据的索引为 k*(2*numRows - 2) + numRows - 1
        // 中间第 i 行的索引有两个，分别为 k*(2*numRows - 2) + i 和 (k + 1)(2*numRows - 2) - i
        int cycleLen = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                sb.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n) {
                    sb.append(s.charAt(j + cycleLen - i));
                }
            }
        }
        return sb.toString();
    }
}
