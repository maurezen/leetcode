package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int ones = 0;
        for (int bits = 0; bits < 32; bits++) {
            ones += n&1;
            n >>>= 1;
        }

        return ones;
    }
}
