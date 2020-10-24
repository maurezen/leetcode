package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    // can do better with the same-ish two pointers going from the top picking the biggest elements one by one
    // there's enough space to fit everything

    // k, we'll do a straightforward square time one with arraycopy
    // will probs still be fast
    public void mergeArracycopy(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0, j=0; i < m+n && j < n;) {
            if (i >= m+j) {
                nums1[i] = nums2[j];
                j++;
                i++;
            } else if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                System.arraycopy(nums1, i, nums1, i+1, m-i+j);
                nums1[i] = nums2[j];
                j++;
                i++;
            }
        }
    }
}
