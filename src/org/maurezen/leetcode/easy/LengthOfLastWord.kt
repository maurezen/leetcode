package org.maurezen.leetcode.easy

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
class LengthOfLastWord {

    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(" ").last().length
    }
}

fun main() {
    val instance = LengthOfLastWord()

    println("lengthOfLastWord(\"Hello World\") = ${instance.lengthOfLastWord("Hello World")}")
}