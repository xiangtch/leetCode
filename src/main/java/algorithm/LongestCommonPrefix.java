package algorithm;

import java.util.Arrays;

/**
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/4/4 22:16
 */
public class LongestCommonPrefix {

    /*
    *    题目：最长公共前缀
    *    编写一个函数来查找字符串数组中的最长公共前缀，如果不存在公共前缀，返回空字符串 “”。
    *    示例 1：
    *       输入：strs = ["flower","flow","flight"]
    *       输出："fl"
    *    示例 2：
    *       输入：strs = ["dog","racecar","car"]
    *       输出：""
    *       解释：输入不存在公共前缀。
    */

    public static void main(String[] args) {
        System.out.println(findLongestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(findLongestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(findLongestCommonPrefix(new String[]{"ab","a"}));
    }

    private static String findLongestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < strings[0].length(); i++) {
            for (int j = 1; j < strings.length; j++) {
                if (strings[j].length() <= i || strings[j].charAt(i) != strings[0].charAt(i)) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(strings[0].charAt(i));
        }
        return commonPrefix.toString();
    }
}
