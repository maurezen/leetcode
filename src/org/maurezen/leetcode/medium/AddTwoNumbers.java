package org.maurezen.leetcode.medium;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode current = null;

        int carry = 0;
        int val = 0;
        while (l1 != null || l2 != null) {
            val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = val > 9 ? 1 : 0;
            val = val % 10;

            ListNode node = new ListNode(val);
            if (result == null) {
                result = node;
                current = result;
            } else {
                current.next = node;
                current = current.next;
            }

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
