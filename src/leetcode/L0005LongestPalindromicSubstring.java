package leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0005LongestPalindromicSubstring {

    static boolean isPalindromic(String str) {
        boolean isPalindromic = true;
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                isPalindromic = false;
                break;
            }
        }
        return isPalindromic;
    }

    static String longestPalindromicSubstring(String str) {
        String maxString = "";
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String tempStr = str.substring(i, j);
                if (isPalindromic(tempStr)) {
                    if (tempStr.length() > maxString.length()) {
                        maxString = tempStr;
                    }
                }
            }
        }

        return maxString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromicSubstring("babad"));
        System.out.println(longestPalindromicSubstring("cbbd"));
    }
}
