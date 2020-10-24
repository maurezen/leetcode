package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 */
public class SquaresSortedArray {
    public int[] sortedSquares(int[] A) {
        //find a point where abs value is minimal
        //should do binary search, but uhhh
        int middle = 0;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i]) < Math.abs(A[middle])) {
                middle = i;
            }
        }

        //then go both sides, merging those
        int[] result = new int[A.length];
        result[0] = A[middle] * A[middle];
        for (int left = middle-1, right = middle+1, index = 1; left >= 0 || right < A.length; index++) {
            boolean advanceRight = false;
            //yup could do advanceRight = 0 == left, but muh readability
            if (0 > left) {
                advanceRight = true;
                //if left is not out of numbers, but right is, no comparison needed
            } else if (A.length > right) {
                advanceRight = A[right]*A[right] <= A[left]*A[left];
            }

            if (advanceRight) {
                result[index] = A[right]*A[right];
                right++;
            } else {
                result[index] = A[left]*A[left];
                left--;
            }
        }

        return result;
    }

}
