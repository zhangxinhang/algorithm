package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0009PalindromeNumber {
    static List<Integer> getNum(int num, int len) {
        List<Integer> list = new ArrayList<>();
        for (int i = len - 1; i > -1; i--) {
            list.add((int) (num / Math.pow(10, i)));
            num = (int) (num % Math.pow(10, i));
        }
        return list;
    }

    static boolean palindromeNumber(int num) {
        boolean ret = false;
        if (num > 0) {
            //10 为最大位数
            for (int len = 2; len <= 10; len++) {
                if (num < Math.pow(10, len)) {
                    ret = true;
                    List<Integer> list = getNum(num, len);
                    for (int i = 0; i < list.size() / 2; i++) {
                        if (!list.get(i).equals(list.get(len - i - 1))) {
                            ret = false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        getNum(1234, 4).forEach(System.out::print);
        System.out.println(palindromeNumber(1234));
        System.out.println(palindromeNumber(1234321));
    }
}
