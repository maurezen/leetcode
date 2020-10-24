package org.maurezen.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    //linear time, but needs linear extra space
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Set<Integer>> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> indices = complements.computeIfAbsent(target - nums[i], k -> new HashSet<>());
            indices.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            if (complements.containsKey(nums[i])) {
                Set<Integer> indices = complements.get(nums[i]);
                result[1] = indices.stream().filter(Predicate.not(Predicate.isEqual(i))).findAny().orElse(-1);
                if (result[1] > -1) {
                    return result;
                }
            }
        }

        return result;
    }

    //O(x^2) for time, but no extra space. Can be sped up to linear, but requiring linear extra space.
    public int[] twoSumSquareTime(int[] nums, int target) {
        int[] result = new int[2];
        for (int first = 0; first < nums.length - 1; first++) {
            result[0] = first;
            final int adjustedTarget = target - nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (adjustedTarget == nums[second]) {
                    result[1] = second;
                    return result;
                }
            }
        }
        return result;
    }
}
