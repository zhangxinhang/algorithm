package leetcode.editor.cn;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法

public class L0004MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new L0004MedianOfTwoSortedArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] num1, int[] num2) {
            double ret = 0;
            if (num1 != null && num2 != null) {
                int len = num1.length + num2.length;
                int m = len / 2;
                boolean isEven = len % 2 == 0;
                int m1 = 0;
                int m2 = 0;
                int i = 0;
                int n1 = 0;
                int n2 = 0;
                while (i <= m) {
                    int current = 0;
                    if (n1 < num1.length && n2 < num2.length) {
                        if (num1[n1] < num2[n2]) {
                            current = num1[n1];
                            n1++;
                        } else {
                            current = num2[n2];
                            n2++;
                        }

                    } else if (n1 < num1.length) {
                        current = num1[n1];
                        n1++;
                    } else if (n2 < num2.length) {
                        current = num2[n2];
                        n2++;
                    }
                    if (i == m - 1 && isEven) {
                        m2 = current;
                    }
                    if (i == m) {
                        m1 = current;
                    }
                    i++;
                }
                if (isEven) {
                    ret = new Double(m1 + m2) / 2;
                } else {
                    ret = m1;
                }
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}