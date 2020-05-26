package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class L0001TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (numMap.containsKey(need)) {
                ret[0] = i;
                ret[1] = numMap.get(need);
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 13;
        int[] ret = twoSum(nums, target);
        Arrays.stream(ret).forEach(System.out::println);
    }
}
