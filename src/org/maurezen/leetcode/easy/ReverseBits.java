package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/reverse-bits/
 */
public class ReverseBits {

    //Follow up:
    //
    //If this function is called many times, how would you optimize it?
    //lol cache
    // you need treat n as an unsigned value
    public int reverseBitsNaive(int n) {

        int reverse = n&1;

        for (int bits = 0; bits < 31; bits++) {
            reverse = reverse << 1;
            n = n >>> 1;
            reverse += n&1;
        }

        return reverse;
    }
}
