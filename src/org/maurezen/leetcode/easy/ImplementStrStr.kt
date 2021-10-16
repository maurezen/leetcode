package org.maurezen.leetcode.easy

/**
 * https://leetcode.com/problems/implement-strstr/
 */
class ImplementStrStr {

    /**
     * Knuth-Morris-Pratt, linear
     */
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) {
            return 0
        }

        val selfLookup = selfLookup(needle)

        var index = 0
        var commonLength = 0
        do {
            commonLength = commonLengthAtIndex(haystack, needle, index, commonLength)
            if (needle.length == commonLength) {
                return index
            } else {
                index += 1
                commonLength = selfLookup[commonLength].coerceAtLeast(0)
            }
        } while (index < haystack.length)

        return -1
    }

    private fun commonLengthAtIndex(haystack: String, needle: String, index: Int, startingShift: Int): Int {
        var length = startingShift

        while (index + length < haystack.length && length < needle.length && haystack[index+length] == needle[length]) {
            length++
        }

        return length
    }

    /**
     * Expects a non-empty argument
     */
    private fun selfLookup(needle: String): IntArray {
        assert(needle.isNotEmpty())

        val lookup = IntArray(needle.length + 1)
        lookup[0] = -1

        var i = 1
        var cnd = 0
        while (i < needle.length) {
            if (needle[i] == needle[cnd]) {
                lookup[i] = lookup[cnd]
            } else {
                lookup[i] = cnd
            }
            while (cnd >= 0 && needle[i] != needle[cnd]) {
                cnd = lookup[cnd]
            }
            i++
            cnd++
        }

        lookup[i] = cnd

        return lookup
    }
}

fun main() {
//    val haystack = "mississippi"
//    val needle = "issip"
//    val haystack = "hello"
//    val needle = "ll"
    val haystack = "aaaaa"
    val needle = "bba"

    println("strStr($haystack, $needle)=${ImplementStrStr().strStr(haystack, needle)}")
}