package org.maurezen.leetcode.hard;

import org.maurezen.leetcode.misc.ListNode;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;
        ListNode current = null;

        int idxAdvance = -1;

        //linear w.r.t. total element qty
        do {
            idxAdvance = -1;
            int minValue = Integer.MAX_VALUE;
            //linear w.r.t. qty of lists - should have done divide&conquer instead, I suppose
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val <= minValue) {
                    idxAdvance = i;
                    minValue = lists[i].val;
                }
            }

            if (idxAdvance != -1) {
                int val = lists[idxAdvance].val;
                lists[idxAdvance] = lists[idxAdvance].next;

                ListNode node = new ListNode(val);
                if (null == result) {
                    result = node;
                    current = result;
                } else {
                    current.next = node;
                    current = current.next;
                }
            }

        } while (idxAdvance != -1);

        return result;
    }
}
