package resolve;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: xiangtch - imsmallmouse@gmail.com
 * @date: 2023/4/13 15:52
 */
public class LengthOfLongestSubstring0003 {

    public static void main(String[] args) {
        /*
        *  给定一个字符串 s，请你找出其中不含重复字符的最长子串的长度
        *
        *  定义一个哈希表记录当前窗口内出现的字符，记为 i 和 j 分别表示不重复字串的开始位置和结束位置，无重复字符字串的最大长度记为 ans.
        *  遍历字符串 s 的每个字符 s[j]，我们记为 c。若 s[i..j-1]窗口内存在c，则 i 循环向右移动，更新哈希表，直至s[i..j-1]窗口不存在c,
        *  循环结束。将 c 加入哈希表中，此时s[i..j]窗口内不含重复元素，更新 ans 的最大值
        *
        *  时间复杂度O(n)
        * */
        System.out.println(lengthOfLongestSubstring("abcbcbb"));
    }

    private static Integer lengthOfLongestSubstring(String s) {
        Set<Character> ss = new HashSet<>();
        int i = 0, ans = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            while (ss.contains(c)) {
                ss.remove(s.charAt(i++));
            }
            ss.add(c);
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
