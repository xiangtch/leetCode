package algorithm;

/**
 * @author xiangtch
 * @date 2019/8/19 21:31
 * <p> Email: xiangtiancheng@deepexi.com </p>
 */
public class IsPalindrome {

    /*
    *   判断一个整数是否是回文数，回文数是指正序和倒序读都是一样的整数
    *
    *   示例1：
    *     输入： 121
    *     输出： true
    *   示例2：
    *     输入： -121
    *     输出： false
    *   示例3：
    *     输入： 10
    *     输出： false
    *
    * */

    public static void main(String[] args) {
        System.out.println(findIsPalindrome(121));
        System.out.println(findIsPalindrome(-121));
        System.out.println(findIsPalindrome(10));
    }

    /**
     *   判断 x 是否为回文数
     *
     * @param x
     * @return
     */
    private static boolean findIsPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        // 存储回文数
        int palindrome = 0;
        while (x > palindrome){
            palindrome = palindrome * 10 + x % 10;
            x = x / 10;
        }
        return x == palindrome || x == palindrome / 10;
    }
}
