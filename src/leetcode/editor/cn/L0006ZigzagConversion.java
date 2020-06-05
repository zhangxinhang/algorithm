package leetcode.editor.cn;
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
// L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串

import java.util.ArrayList;
import java.util.List;

public class L0006ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new L0006ZigzagConversion().new Solution();
        System.out.println(solution.convert("AB", 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int i = 0;
            int j = 0;
            boolean isPositive = true;
            List<List<Character>> list = new ArrayList<>();
            for (int k = 0; k < numRows; k++) {
                list.add(new ArrayList<>());
            }
            while (i < s.length()) {
                list.get(j).add(s.charAt(i));
                if (isPositive) {
                    if (j == numRows - 1) {
                        j--;
                        isPositive = false;
                    } else {
                        j++;
                    }
                } else {
                    if (j == 0) {
                        j++;
                        isPositive = true;
                    } else {
                        j--;
                    }
                }
                i++;
            }
            StringBuilder sb = new StringBuilder();
            for (List<Character> list1 : list) {
                for (Character c : list1) {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}