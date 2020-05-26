package leetcode;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L0004MedianOfTwoSortedArrays {

    static float medianOfTwoSortedArrays(int[] num1, int[] num2) {
        float ret = 0;
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
                ret = new Float(m1 + m2) / 2;
            } else {
                ret = m1;
            }
        }
        return ret;
    }

    /**
     * //i 值可以直接跳跃到最终行，待完成
     *
     * @param num1
     * @param num2
     * @return
     */
    static float medianOfTwoSortedArrays1(int[] num1, int[] num2) {
        float ret = 0;
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
                    //i 值可以直接跳跃到最终行，待完成
                } else if (n1 < num1.length) {
                    current = num1[n1];
                    n1++;
                    if (i < m - 1) {
                        int index = m - i;
                        m1 = num1[n1 + index - 1];
                        if (isEven) {
                            m2 = num1[n1 + index - 2];
                        }
                        break;
                    }

                } else if (n2 < num2.length) {
                    current = num1[n2];
                    n2++;
                    if (i < m - 1) {
                        int index = m - i;
                        m1 = num2[n2 + index - 1];
                        if (isEven) {
                            m2 = num2[n2 + index - 2];
                        }
                        break;
                    }
                }
                if (i == m - 1 && isEven) {
                    m2 = current;
                }
                if (i == m) {
                    m1 = current;
                }
                i++;
            }
            System.out.println(m1 + "," + m2);
            if (isEven) {
                ret = new Float(m1 + m2) / 2;
            } else {
                ret = m1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 5, 6, 7, 8, 9, 10, 11};
        int[] num2 = new int[]{2};
        System.out.println(medianOfTwoSortedArrays1(num1, num2));

        int[] num3 = new int[]{1, 2};
        int[] num4 = new int[]{3, 4};
        System.out.println(medianOfTwoSortedArrays(num3, num4));
    }

}
