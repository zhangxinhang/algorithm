package leetcode.editor.cn;
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

public class L0003LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new L0003LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String str) {
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
    }
//leetcode submit region end(Prohibit modification and deletion)

}