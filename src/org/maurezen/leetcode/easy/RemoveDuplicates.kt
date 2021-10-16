package org.maurezen.leetcode.easy

private const val TERMINAL = -420

fun main() {
//    val nums = intArrayOf(1, 1, 2)
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
//    val nums = intArrayOf();

    println(nums.contentToString())
    println(removeDuplicates(nums))

    println(nums.contentToString())
}

fun removeDuplicates(nums: IntArray): Int {
    var index = 0
    var duplicates = 0
    if (nums.isNotEmpty()) {
        do {
            duplicates += collapseAt(nums, index++, nums.size - duplicates)
        } while (index + duplicates < nums.size)
    }
    return nums.size - duplicates
}

/**
 * @return the amount of deleted duplicates
 */
fun collapseAt(nums: IntArray, index: Int, end: Int = nums.size): Int {
    var lastIndex = index
    do {
        lastIndex++
    } while (lastIndex < end && nums[lastIndex] == nums[index])

    System.arraycopy(nums, lastIndex, nums, index+1, end - lastIndex)
    nums.fill(TERMINAL, end)

    return lastIndex - index - 1
}