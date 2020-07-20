package leetcode.editor.cn;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1173 👎 0

import java.util.ArrayList;
import java.util.List;

public class L0022GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new L0022GenerateParentheses().new Solution();
        solution.generateParenthesis(1).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> retList = new ArrayList<>();
            backtrack("", retList, n, n);
            return retList;
        }

        public void backtrack(String sublist, List<String> res, int left, int right) {
            if (left == 0 && right == 0) {
                res.add(sublist);
                return;
            }
            if (left > right)
                return;

            if (left > 0)
                backtrack(sublist + "(", res, left - 1, right);
            if (right > 0)
                backtrack(sublist + ")", res, left, right - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}