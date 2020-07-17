package leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 552 👎 0

import leetcode.editor.cn.common.ListNode;

public class L0024SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new L0024SwapNodesInPairs().new Solution();
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
        public ListNode swapPairs(ListNode head) {
            ListNode cur = head;
            ListNode up = head;
            int count = 0;
            while (cur != null && cur.next != null) {
                ListNode temp = cur.next;
                if (temp != null) {
                    cur.next = temp.next;
                    temp.next = cur;
                    if (count == 0) {
                        head = temp;
                    } else {
                        up.next = temp;
                    }
                    up = cur;
                    count++;
                    cur = cur.next;
                }
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}