package leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串

public class L0014LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new L0014LongestCommonPrefix().new Solution();
        String[] strs = {"aa"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder("");
            int j = 0;
            if (strs.length > 0) {
                if (strs.length == 1) {
                    return strs[0];
                }
                int minLength = Integer.MAX_VALUE;
                while (j < minLength)
                    for (int i = 0; i < strs.length; i++) {
                        int length = strs[i].length();
                        if (length == 0) {
                            minLength = 0;
                            break;
                        }
                        if (length < minLength) {
                            minLength = length;
                        }
                        if (i > 0 && strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                            minLength = 0;
                            break;
                        }
                        if (i == strs.length - 1 && strs[i].charAt(j) == strs[i - 1].charAt(j)) {
                            sb.append(strs[i].charAt(j));
                            j++;
                        }

                    }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}