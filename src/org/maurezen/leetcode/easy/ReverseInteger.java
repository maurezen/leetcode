package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        if (Integer.MIN_VALUE == x) {
            return 0;
        } else if (x < 0) {
            return -reverse(-x);
        }

        int reverse = x % 10;

        while (x >= 10) {
            int shifted = reverse * 10;
            //overflow check
            if (reverse != shifted / 10) {
                return 0;
            }
            reverse = shifted;
            x /= 10;
            reverse += x % 10;
        }

        return reverse;
    }
}
