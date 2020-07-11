package leetcode.editor.cn;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1142 👎 0

import leetcode.editor.cn.common.ListNode;

public class L0021MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new L0021MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        solution.mergeTwoLists(l1, l2).print();

    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode head = null;
            ListNode cur = null;
            while (l1 != null && l2 != null) {
                ListNode newNode = l1.val < l2.val ? l1 : l2;
                if (cur == null) {
                    head = newNode;
                } else {
                    cur.next = newNode;
                }
                cur = newNode;
                if (l1.val < l2.val) {
                    l1 = l1.next;
                    if (l1 == null) {
                        cur.next = l2;
                    }
                } else {
                    l2 = l2.next;
                    if (l2 == null) {
                        cur.next = l1;
                    }
                }
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}