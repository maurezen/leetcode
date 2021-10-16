package org.maurezen.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] args) {
//        String s = "()[]{}";
        String s = "([)]";
        System.out.println("isValid(\"" + s + "\") = " + isValid(s));
    }
    
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        AtomicBoolean valid = new AtomicBoolean(true);
        s.chars().forEach(ch -> {
            if (valid.get()) {
                char chAr = (char) ch;

                if (isOpeningBracket(chAr)) {
                    stack.push(chAr);
                } else {
                    Character lastBracket = stack.poll();

                    if (null == lastBracket || lastBracket != getOpeningBracket(chAr)) {
                        valid.set(false);
                    }
                }
            }
        });

        return valid.get() && stack.isEmpty();
    }

    private static boolean isOpeningBracket(char ch) {
        return '(' == ch || '[' == ch || '{' == ch;
    }

    private static char getOpeningBracket(char closing) {
        switch (closing) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: throw new IllegalArgumentException("Only expect ()[]{} brackets, instead found: " + closing);
        }
    }

    private static class Pair<T, U> {

        private T first;
        private U second;

        private Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
