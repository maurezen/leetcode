package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    //say hello to binary search, huh
    public int searchInsert(int[] nums, int target) {
        int beg = 0, end = nums.length - 1, mid = end/2;

        do {
            if (end - beg <= 1) {
                if (nums[beg] >= target) {
                    mid = beg;
                } else if (nums[end] < target) {
                    mid = end+1;
                } else if (nums[end] >= target) {
                    mid = end;
                }
                break;
            } else if (nums[mid] == target) {
                break;
            } else if (nums[mid] > target) {
                end = mid;
                mid = (end + beg) / 2;
            } else {
                beg = mid;
                mid = (end + beg) / 2;
            }
        } while (beg != mid || mid != end);

        return mid;
    }
}
