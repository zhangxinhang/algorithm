package leetcode.editor.cn;
//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 881 👎 0

public class L0019RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new L0019RemoveNthNodeFromEndOfList().new Solution();
        ListNode head = new ListNode(1);
        ListNode cur = head;
       /* for (int i : new int[]{2}) {
            ListNode next = new ListNode(i);
            cur.next = next;
            cur = next;
        }*/
        ListNode l = solution.removeNthFromEnd(head, 1);
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode l1 = head, l2 = head;
            int i = 0;
            while (l1 != null) {
                l1 = l1.next;
                i++;
                if (l1 == null) {
                    if (i == n) {
                        head = head.next;
                    } else {
                        l2.next = l2.next.next;
                    }
                } else {
                    if (i > n) {
                        l2 = l2.next;
                    }
                }


            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}