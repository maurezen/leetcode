package org.maurezen.leetcode.medium;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] onesPerNumber = new int[num+1];

        //so if we recursively generate binary digits,
        //1 -> (0,1)
        //n -> (0xgen(n-1),1xgen(n-1))
        //we know that second half
        //contains about the same stuff as previous half, but one binary 1 more

        onesPerNumber[0] = 0;

        for (int i = 0; 1 << i <= num; i++) {
            int breakpoint = 1 << i;
            for (int j = breakpoint; (j < breakpoint << 1) && (j <= num); j++) {
                onesPerNumber[j] = 1 + onesPerNumber[j - breakpoint];
            }
        }

        return onesPerNumber;
    }
}
