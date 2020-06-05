package leetcode.editor.cn;
//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。 
// Related Topics 数学

import java.util.ArrayList;
import java.util.List;

public class L0007ReverseInteger {
    public static void main(String[] args) {

        Solution solution = new L0007ReverseInteger().new Solution();
        System.out.println(solution.reverse(1534236469));
        System.out.println(Math.pow(2, 31));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int num) {

            List<Integer> list = new ArrayList<>();
            boolean isPositive = true;
            if (num < 0) {
                num = Math.abs(num);
                isPositive = false;
            }
            while (num != 0) {
                int n = num % 10;
                list.add(n);
                num = num / 10;
            }
            int temp = 0;
            int len = list.size();
            for (int i = 0; i < list.size(); i++) {
                temp += list.get(i) * Math.pow(10, len - 1 - i);
            }
            if (!isPositive) {
                temp = -temp;
            }
            if (temp <= -2147483647 || temp >= 2147483647) {
                return 0;
            }
            return temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}