package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.*;

public class L0015ThreeSum {
    public static void main(String[] args) {
        Solution solution = new L0015ThreeSum().new Solution();
        solution.threeSum(new int[]{14, 9, 14, -9, -6, -10, 2, 6, -11, -5, 12, -6, 6, -6, -9, -1, -14,
                7, -9, 13, 8, 9, 9, 10, 8, 5,
                -10, -11, -9, -4, -15, -10, -10, -15, -12, -9, 12, 5, 4, -14, -15, 1, -5,
                -2, 3, -7, 4, 4, -14, 10, 2, 1, -4, -12, -12, -11, 8, -7, -15, 6, 4, 8, 11, 1, 0, 6,
                -1, -3, -12, -12, -10, 10, 4, -8, -15, 14, 0, 5, 3, 1, -8, -9, 9, 4, -14, 12, 8, 10,
                12, 1, 1, -7, -6, -10, 1, 9, 3, -15, 13, 7, -12, -12, -6, 0})
                .forEach(integers -> integers.forEach(System.out::println));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                List<Integer> item = map.getOrDefault(nums[i], new ArrayList<>());
                item.add(i);
                map.put(nums[i], item);
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == j) {
                        continue;
                    }
                    Integer need = -nums[i] - nums[j];
                    List<Integer> values = map.get(need);
                    if (null != values) {
                        int k = -1;
                        for (Integer value : values) {
                            if (value != j && value != i) {
                                k = value;
                                break;
                            }
                        }
                        if (k != -1) {
                            Integer[] arr = new Integer[]{nums[i], nums[j], nums[k]};
                            Arrays.sort(arr);
                            String key = String.format("%d,%d,%d", arr[0], arr[1], arr[2]);
                            if (!set.contains(key)) {
                                set.add(key);
                                list.add(Arrays.asList(arr));
                            }
                        }
                    }
                }
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}