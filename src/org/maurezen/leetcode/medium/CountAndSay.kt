package org.maurezen.leetcode.medium

import java.util.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * https://leetcode.com/problems/count-and-say/
 */
class CountAndSay {

    fun countAndSay(n: Int): String {
        return if (1 == n) "1" else countAndSay(countAndSay(n - 1))
    }

    //this mutates the string in a count-and-say manner
    fun countAndSay(s: String): String {
        val queue = countCharSpans(s)

        return queue.joinToString("") { it.second.get().toString() + it.first }
    }

    private fun countCharSpans(s: String): ArrayDeque<Pair<Char, AtomicInteger>> {
        val queue = ArrayDeque<Pair<Char, AtomicInteger>>()

        s.forEach {
            if (queue.isEmpty() || queue.last.first != it) {
                queue.offer(Pair(it, AtomicInteger(1)))
            } else {
                queue.last.second.incrementAndGet()
            }
        }

        return queue
    }
}


fun main() {
    val instance = CountAndSay()

    println("boo ${instance.countAndSay(4)}")
}