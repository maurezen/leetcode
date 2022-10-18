package org.maurezen.leetcode.easy

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        val builder = StringBuilder()

        strs.first().forEachIndexed { index, c ->
            if (strs.all { it.length > index } && strs.all { it[index] == c }) {
                builder.append(c)
            } else {
                return builder.toString()
            }
        }

        return builder.toString()
    }
}

fun main() {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}