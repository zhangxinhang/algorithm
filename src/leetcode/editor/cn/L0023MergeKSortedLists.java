package leetcode.editor.cn;
//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法 
// 👍 788 👎 0


import leetcode.editor.cn.common.ListNode;

public class L0023MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new L0023MergeKSortedLists().new Solution();
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 4}),
                new ListNode(new int[]{2, 6}),
        };
        solution.mergeKLists(lists).print();
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            int n = lists.length;
            while (n > 1) {
                int k = (n + 1) / 2;
                for (int i = 0; i < n / 2; ++i) {
                    lists[i] = mergeTwoLists(lists[i], lists[i + k]);
                }
                n = k;
            }
            return lists[0];
        }

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