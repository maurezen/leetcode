package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits/
 */
public class AlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int lsb = n&1;
        n >>= 1;

        boolean hasAlternatingBits = true;
        while (n > 0 && hasAlternatingBits) {
            hasAlternatingBits = lsb != (n&1);
            lsb = n&1;
            n >>= 1;
        }

        return hasAlternatingBits;
    }
}
