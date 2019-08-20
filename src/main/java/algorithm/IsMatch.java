package algorithm;

/**
 *   正则表达式匹配
 *
 * @author xiangtch
 * @date 2019/8/20 10:39
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class IsMatch {

    /*
    *   给一个字符串 s 和一个字符规律 p，请你来实现一个支持 "." 和 "*" 的正则表达式匹配
    *   "." 匹配任意单个字符
    *   "*" 匹配零个或多个前面的那一个元素
    *   所谓匹配，是涵盖整个字符串 s 的，而不是部分字符串
    * 说明：
    *   - s 可能为空，且只包含从 a-z 的小写字母
    *   - p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 * 。
    *
    * 示例1：
    *   输入：
    *     s = "aa"
    *     p = "a"
    *   输出： false
    * 示例2：
    *   输入：
    *     s = "aa"
    *     p = "a*"
    *   输出： true
    * 示例3：
    *   输入：
    *     s = "ab"
    *     p = ".*"
    *   输出： true
    * 示例4：
    *   输入：
    *     s = "aab"
    *     p = "c*a*b"
    *   输出： true
    * 示例5：
    *   输入：
    *     s = "mississippi"
    *     p = "mis*is*p*."
    *   输出： false
    *
    * */

    public static void main(String[] args) {
        System.out.println(findIsMatch("aa", "a"));
        System.out.println(findIsMatch("aa", "a*"));
        System.out.println(findIsMatch("ab", ".*"));
        System.out.println(findIsMatch("aab", "c*a*b"));
        System.out.println(findIsMatch("mississippi", "mis*is*p*."));
    }

    /**
     *   正则表达式匹配
     *
     * @param s
     * @param p
     * @return
     */
    private static boolean findIsMatch(String s, String p) {
        // 空字符
       if(s == null){
           if (p == null){
               return true;
           }else {
               return false;
           }
       }
       if (s.equals(p)){
           return true;
       }
       return s.matches(p);
    }
}
