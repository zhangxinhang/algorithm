package leetcode.editor.cn.common;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] nums) {
        this.val = nums[0];
        ListNode cur = this;
        for (int i = 1; i < nums.length; i++) {
            ListNode next = new ListNode(nums[i]);
            cur.next = next;
            cur = next;
        }
    }

    public void print() {
        ListNode l = this;
        while (l != null) {
            System.out.print(l.val + "->");
            l = l.next;
        }
    }
}
