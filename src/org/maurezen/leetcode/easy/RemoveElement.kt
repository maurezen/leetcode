package org.maurezen.leetcode.easy

/**
 * https://leetcode.com/problems/remove-element/
 */
class RemoveElement {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var index = 0
        var duplicates = 0
        while (index < nums.size - duplicates) {
            if (`val` == nums[index]) {
                swapInPlace(nums, index, nums.size - ++duplicates)
            } else {
                index++
            }
        }

        return nums.size - duplicates
    }

    //yes I'm not a fan of removing kebab
    private fun swapInPlace(nums: IntArray, firstIndex: Int, secondIndex: Int) {
        val holder = nums[firstIndex]
        nums[firstIndex] = nums[secondIndex]
        nums[secondIndex] = holder
    }
}

fun main() {
    val instance = RemoveElement()

    val smolNums = intArrayOf(3, 2, 2, 3)
    println("before: ${smolNums.asList()} after size: ${instance.removeElement(smolNums, 3)} after: ${smolNums.asList()}")
    val boggerNums = intArrayOf(0,1,2,2,3,0,4,2)
    println("before: ${boggerNums.asList()} after size: ${instance.removeElement(boggerNums, 2)} after: ${boggerNums.asList()}")
}