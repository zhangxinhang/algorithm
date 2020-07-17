package leetcode.editor.cn;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

import leetcode.editor.cn.common.ListNode;

import java.util.Objects;

public class L0002AddTwoNumbers {
    public static void main(String[] args) {

        Solution solution = new L0002AddTwoNumbers().new Solution();

    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode current = null;
            int tempAdd = 0;
            while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
                int a = 0;
                int b = 0;
                if (Objects.nonNull(l1)) {
                    a = l1.val;
                    l1 = l1.next;
                }
                if (Objects.nonNull(l2)) {
                    b = l2.val;
                    l2 = l2.next;
                }
                int tempR = a + b + tempAdd;
                tempAdd = 0;
                if (tempR >= 10) {
                    tempR -= 10;
                    tempAdd = 1;
                }
                if (Objects.isNull(current)) {
                    current = new ListNode(tempR);
                    head = current;
                } else {
                    current.next = new ListNode(tempR);
                    current = current.next;
                }
            }
            if (tempAdd == 1) {
                current.next = new ListNode(1);
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}