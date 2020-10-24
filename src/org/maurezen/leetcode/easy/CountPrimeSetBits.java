package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
 */
public class CountPrimeSetBits {

    public int countPrimeSetBits(int L, int R) {
        int good = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(countSetBits(i))) {
                good++;
            }
        }

        return good;
    }

    //num < 10k by design => 100 cycles tops, no need to complicate
    public boolean isPrime(int num) {
        boolean prime = num > 1;
        for (int i = 2; i <= Math.sqrt(num) && prime; i++) {
            prime = num % i > 0;
        }
        return prime;
    }

    //num > 0 by design
    public int countSetBits(int num) {
        int bits = 0;
        while (num > 0) {
            bits += num&1;
            num >>= 1;
        }
        return bits;
    }
}
