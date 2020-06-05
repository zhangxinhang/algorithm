package old;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0006ZigZagConversion {
    static String zigZagConversion(String s, int numRows) {
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

    public static void main(String[] args) {
        System.out.println(zigZagConversion("LEETCODEISHIRING", 3));
        System.out.println(zigZagConversion("LEETCODEISHIRING", 4));
    }
}
