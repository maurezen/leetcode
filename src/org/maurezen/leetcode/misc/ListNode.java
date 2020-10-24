package org.maurezen.leetcode.misc;

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

    public static ListNode reverse(ListNode head) {
        ListNode tail = head;

        if (head.next == null) {
            return tail;
        }

        ListNode n = head.next;

        while (n.next != null) {
            ListNode tailNext = tail;
            tail = n;
            n = n.next;
            tail.next = tailNext;
        }

        return tail;
    }
}
