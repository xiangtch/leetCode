package algorithm;

/**
 *   最长回文子串
 *
 * @author xiangtch
 * @date 2019/7/18 19:16
 * @email xiangtiancheng@deepexi.com
 */
public class LongestPalindrome {

    /*
    *   题目：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
    *
    *   示例 1：
    *       输入："babad"
    *       输出："bab"
    *       注意："aba" 也是一个有效答案
    *   示例 2:
    *       输入："cddb"
    *       输出："bb"
    * */

    public static void main(String[] args) {
        String str1 = "babad";
        String palindrome1 = findLongestPalindrome(str1);
        System.out.println(palindrome1);
        String str2 = "cddb";
        String palindrome2 = findLongestPalindrome(str2);
        System.out.println(palindrome2);
        System.out.println(findLongestPalindrome("aaaa"));
        System.out.println(findLongestPalindrome("aa"));
    }

    private static final int typeElement = 0;

    private static final int typeBlank = 1;


    /**
     *   找到 str 中的最大回文子串
     *
     * @param str
     * @return
     */
    private static String findLongestPalindrome(String str) {
        // 获取元素的个数
        int maxElementIndex = str.length();
        String longestPalindromeElement = findLongestPalindromeByCenter(str, maxElementIndex, typeElement);
        // 获取空格的个数
        int maxBlankIndex = str.length();
        String longestPalindromeBlank = findLongestPalindromeByCenter(str, maxBlankIndex, typeBlank);
        return longestPalindromeElement.length() > longestPalindromeBlank.length() ? longestPalindromeElement : longestPalindromeBlank;
    }

    /**
     *  根据元素长度和元素类型获取最大回文子串
     *
     *
     * @param str
     * @param maxElementIndex 回文中心元素个数
     * @param typeElement 回文中心元素类型，str 的元素 与 空格 两种类型
     * @return
     */
    private static String findLongestPalindromeByCenter(String str, int maxElementIndex, int typeElement) {
        // 定义子序列的开始位置
        int start;
        // 子序列结束位置
        int end;
        // 最长回文子序列长度
        int max = 0;
        // 最长回文子串
        String longestPalindrome = "";
        // 遍历字符串，判断以每个元素为回文中心的子序列
        for (int i = typeElement; i < maxElementIndex; i++){
            // 构建对应元素的子序列
            for (int j = 0; j <= i -typeElement  && j < maxElementIndex - i; j++){
                start = i - j - typeElement;
                end = i + j;
                // 判断子序列是否是回文子串
                boolean isPalindrome = checkPalindrome(str, start, end);
                // 如果不是回文子串，结束以此元素为中心的遍历
                if (!isPalindrome){
                    break;
                }
                // 如果回文串的长度大于 max，更新 max 与 longestPalidrome
                if ((end - start + 1) > max){
                    max = end - start + 1;
                    longestPalindrome = str.substring(start, end + 1);
                }
            }
        }
        return longestPalindrome;
    }

    /**
     *   判断 str 的子序列是否是回文子串
     *
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static boolean checkPalindrome(String str, int start, int end) {
        // 分别从两边开始遍历
        while (end > start){
            if (str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
