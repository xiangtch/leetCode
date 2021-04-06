package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangtch - xiangtch6@gmail.com
 * @date 2021/4/6 21:02
 */
public class LetterCombinations {

    /*
    *    题目：电话号码的字母组合
    *    给定一个仅包含数字 2-9 的字符串，返回它能表示的所有字母组合。答案可以按任意顺序返回。
    *    示例 1：
    *       输入：digits = "23"
    *       输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
    *    示例 2：
    *       输入：digits = ""
    *       输出：[]
    *    示例 3：
    *       输入：digits = "2"
    *       输出：["a","b","c"]
    */

    public static void main(String[] args) {
        System.out.println(findLetterCombinations("23"));
        System.out.println(findLetterCombinations(""));
        System.out.println(findLetterCombinations("2"));
    }

    private static List<String> findLetterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }

        Map<Character, String> digitMap = new HashMap<>(8);
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");

        backtrack(combinations, digitMap, digits, 0, new StringBuffer());
        return combinations;
    }

    private static void backtrack(List<String> combinations, Map<Character, String> digitMap, String digits,
                                  int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = digitMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, digitMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
