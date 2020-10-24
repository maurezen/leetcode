package org.maurezen.leetcode.easy;

import org.maurezen.leetcode.misc.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
    //wtf
    //this is the most straightforward solution
    //how come it's so fast
    //alright, that's a reporting issue, they have 58% ppl faster than 1 ms and can't count on a more granular level
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();

        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        if (l1.val <= l2.val) {
            result.val = l1.val;
            l1 = l1.next;
        } else {
            result.val = l2.val;
            l2 = l2.next;
        }

        ListNode index = result;

        while (null != l1 || null != l2) {
            boolean advanceFirst = compare(l1,l2) <= 0;
            if (advanceFirst) {
                //advanceFirst is null-aware, so l1 is not null here
                index.next = new ListNode(l1.val);
                index = index.next;
                l1 = l1.next;
            } else {
                index.next = new ListNode(l2.val);
                index = index.next;
                l2 = l2.next;
            }
        }

        return result;
    }

    //return <0 if l1 < l2
    //null is less than everything else
    public int compare(ListNode l1, ListNode l2) {
        if (null == l1) {
            return 1;
        } else if (null == l2) {
            return -1;
        } else {
            return l1.val - l2.val;
        }
    }
}