package org.maurezen.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIISortedInput {

    //gee had to debug a bit
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumIISortedInput().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public int[] twoSum(int[] numbers, int target) {
        return twoSumHashSpeedup(numbers, target);
    }

    //what we can also do is introduce a binary search that would reduce a linear lookup to a logarithmic one
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        //we know for sure that first of our pair is at least numbers[0]
        //therefore, any second number should be at most target - numbers[0]
        for (int first = 0; first < numbers.length - 1 && numbers[first] <= target - numbers[0]; first++) {

            //too lazy to implement myself, shouldn't be hard to do (probably should be done in an interview environment)
            int second = Arrays.binarySearch(numbers, target - numbers[first]);
            if (second > 0) {
                if (numbers[second] == numbers[first] && second == first) {
                    second++;
                }
                return new int[]{first + 1, second + 1};
            }
        }

        return new int[2];
    }

    //we can introduce the same hashmap speedup technique for additional memory
    public int[] twoSumHashSpeedup(int[] numbers, int target) {
        int[] result = new int[2];

        HashMap<Integer, HashSet<Integer>> complements = new HashMap<>();

        //we know for sure that first of our pair is at least numbers[0]
        //therefore, any second number should be at most target - numbers[0]
        for (int i = 0; i < numbers.length && numbers[i] <= target - numbers[0]; i++) {
            int complement = target - numbers[i];
            Set<Integer> indices = complements.computeIfAbsent(complement, k -> new HashSet<>());
            indices.add(i);
        }

        for (int first = 0; first < numbers.length - 1; first++) {
            result[0] = first;

            if (complements.containsKey(numbers[first])) {
                int second = complements.get(numbers[first]).stream().filter(Predicate.not(Predicate.isEqual(first))).findAny().orElse(-1);
                if (-1 < second) {
                    result[1] = second;
                    result[0]++;
                    result[1]++;
                    return result;
                }
            }
        }

        return result;
    }

    //this is the same old O(x^2)
    public int[] twoSumSquareTime(int[] numbers, int target) {
        int[] result = new int[2];

        for (int first = 0; first < numbers.length - 1; first++) {
            result[0] = first;
            for (int second = first + 1; second < numbers.length && numbers[first] + numbers[second] <= target; second++) {
                if (numbers[second] + numbers[first] == target) {
                    result[1] = second;
                    result[0]++;
                    result[1]++;
                    return result;
                }
            }
        }

        return result;
    }
}
