package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class L0002AddTwoNumbers {
    static int getValue(List<Integer> list, int index) {
        int value = 0;
        if (index < list.size()) {
            value = list.get(index);
        }
        return value;
    }

    static List<Integer> addTwoNumbers(List<Integer> a, List<Integer> b) {
        List<Integer> ret = new LinkedList<>();
        int length = Math.max(a.size(), b.size());
        int tempAdd = 0;
        for (int i = 0; i < length; i++) {
            int tempA = getValue(a, i);
            int tempB = getValue(b, i);
            int tempR = tempA + tempB + tempAdd;
            tempAdd = 0;
            if (tempR >= 10) {
                tempR -= 10;
                tempAdd = 1;
            }
            ret.add(tempR);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(2, 4, 3, 4);
        List<Integer> b = Arrays.asList(5, 6, 4);
        List<Integer> ret = addTwoNumbers(a, b);
        ret.stream().forEach(System.out::print);
    }
}
