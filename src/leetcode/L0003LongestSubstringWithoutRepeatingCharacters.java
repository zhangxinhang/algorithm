package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0003LongestSubstringWithoutRepeatingCharacters {
    /**
     * 遇到重复字符时，从第一次出现字符的位置重新开始。
     *
     * @param str
     * @return
     */
    static int longestSubstringWithoutRepeatingCharacters(String str) {
        int ret = 0;
        int current = 0;
        Map<Character, Integer> tempMap = new HashMap<>();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (tempMap.containsKey(c)) {
                i = tempMap.get(c);
                tempMap.clear();
                current = 0;
            } else {
                tempMap.put(c, i);
                current++;
                if (current > ret) {
                    ret = current;
                }
            }
            i++;
        }
        return ret;
    }

    /**
     * 可以在遇到重复字符时，复用之前的数据
     *
     * @param str
     * @return
     */
    static int longestSubstringWithoutRepeatingCharacters1(String str) {
        int ret = 0;
        int current = 0;

        StringBuilder newStr = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            int index = newStr.indexOf(c + "");
            if (index > -1) {
                newStr = new StringBuilder(newStr.substring(index + 1));
                current = newStr.length();
            }
            newStr.append(c);
            current++;
            if (current > ret) {
                ret = current;
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters1("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters1("bbbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters1("pwwkew"));
    }
}
