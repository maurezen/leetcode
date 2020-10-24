package org.maurezen.leetcode.easy;

import org.maurezen.leetcode.misc.ListNode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

    // assuming we can mutilate the list
    // double scan to happen at the middle AND at the end at the same time
    // reverse first part along the way
    // end up with two lists going mid-to-head and mid-to-tail
    // trivially compare these two
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode tail = head;
        ListNode midToTail = head;

        //so tail = tail.next.next is always a thing
        //System.out.println("double-scanning");
        while (tail != null && tail.next != null) {
            // double scan to happen at the middle AND at the end at the same time
            //System.out.println("tail="+tail.val+" mid2tail="+midToTail.val);
            tail = tail.next.next;
            midToTail = midToTail.next;
        }
        //System.out.println("tail="+(tail == null ? "null" : tail.val)+" mid2tail="+midToTail.val);
        // atm either tail == null or tail.next == null
        if (tail == null) {
            //list size is even, midToTail is to the right of midpoint
        } else {
            //list size is odd, midToTail is exactly at the midpoint
        }
        // reverse first part the way
        ListNode midToHead = head;
        ListNode n = head.next;
        midToHead.next = null;
        //System.out.println("midToHead="+midToHead.val+" n="+n.val);

        if (n == midToTail) {
            if (tail != null) {
                midToTail = midToTail.next;
            }
            return head.val == midToTail.val;
        }

        //System.out.println("reverse");
        while (n != midToTail) {
            //System.out.println("n="+n.val+" mid2head="+midToHead.val);
            ListNode mthNext = midToHead;
            midToHead = n;
            n = n.next;
            midToHead.next = mthNext;
        }
        //System.out.println("n="+n.val+" mid2head="+midToHead.val);
        // n = midToTail now; midToHead is one step before that
        if (tail != null) {
            //who needs a midpoint
            midToTail = midToTail.next;
        }

        // end up with two lists going mid-to-head and mid-to-tail
        // trivially compare these two
        boolean palindrome = true;
        //System.out.println("comparison");
        while (midToHead != null && midToTail != null) {
            //System.out.println("midToTail="+midToTail.val+" mid2head="+midToHead.val);
            palindrome &= midToHead.val == midToTail.val;
            midToHead = midToHead.next;
            midToTail = midToTail.next;
        }
        //System.out.println("midToTail="+(midToTail == null ? "null" : midToTail.val)+" mid2head="+(midToHead == null ? "null" : midToHead.val));
        palindrome &= midToHead == null && midToTail == null;

        return palindrome;
    }

    //first of all, dumb O(n) space thing
    public boolean isPalindromeLinear(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();

        while (head != null) {
            list.add(head);
            head = head.next;
        }

        int len = list.size();
        for (int i = 0; i < len/2; i++) {
            if (list.get(i).val != list.get(len - i - 1).val) {
                return false;
            }
        }

        return true;
    }
}
