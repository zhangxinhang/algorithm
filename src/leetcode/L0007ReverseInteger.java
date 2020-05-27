package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 */
public class L0007ReverseInteger {
    static int reverseInteger(int num) {
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
            temp = 0 - temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(123));
        System.out.println(reverseInteger(-1234));
    }
}
