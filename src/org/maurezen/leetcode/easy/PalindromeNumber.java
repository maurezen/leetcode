package org.maurezen.leetcode.easy;

/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    public static void main(String[] args) {

    }

    //we still need to compare least significant digit with the most significant one
    //ideally not plopping digits onto stack because duh, additional memory
    //(if I wanted additional memory, I would use the string version)
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }

        //funnily enough, this works a tad slower than a naive linear implementation (and is more error-prone to boot)
        //slower in a real-life sense, not in an asymptotic sense
        int digits = (int) Math.floor(Math.log10(x)) + 1;
        int topmost = (int) Math.pow(10, digits - 1);

        while (x / topmost > 9) {
            topmost *= 10;
            digits++;
        }

        boolean palindrome = true;
        do {
            //this is a cycle doofus, y r you highlighting this
            palindrome &= (x / topmost) == (x % 10);

            x -= topmost * (x / topmost);
            topmost /= 100;
            x /= 10;
            digits -= 2;
        } while (palindrome && digits > 1);

        return palindrome;
    }

    //first of all, a straightforward thing with a String
    public boolean isPalindromeString(int x) {
        String string = (Integer.valueOf(x)).toString();

        int len = string.length();
        for (int i = 0; i < len/2; i++) {
            if (string.charAt(i) != string.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
