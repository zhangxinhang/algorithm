package other;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1 = -1;
        int index2 = -1;
        int sumLength = length1 + length2;
        if ((length1 + length2) % 2 == 0) {
            index1 = sumLength / 2 - 1;
            index2 = index1 + 1;
        } else {
            index1 = Math.round(sumLength / 2);
        }
        int i = 0, j = 0, k = 0;
        int num1 = 0, num2 = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (i < length1 || j < length2) {
            int a = i < length1 ? nums1[i] : Integer.MAX_VALUE;
            int b = i + 1 < length1 ? nums1[i + 1] : Integer.MAX_VALUE;
            int c = j < length2 ? nums2[j] : Integer.MAX_VALUE;
            int d = j + 1 < length2 ? nums2[j + 1] : Integer.MAX_VALUE;

            if (a <= c && b <= c) {//a,b,c
                i += 2;
                num1 = a;
                num2 = b;
            } else if (a <= c && b >= c) {//a,c,b
                i++;
                j++;
                num1 = a;
                num2 = c;
            } else if (a >= c && a >= d) {//c,d,a,b
                j += 2;
                num1 = c;
                num2 = d;
            } else if (a >= c && d >= a) {//c,a,d,b
                i++;
                j++;
                num1 = c;
                num2 = a;
            }
            list.add(num1);
            list.add(num2);
            System.out.println("num1:" + num1 + ",num2:" + num2 + ",index:" + index1 + ",index2:" + index2);

            if (k == index1) {
                if (index2 == -1) {
                    median = list.get(index1);
                } else {
                    median = (list.get(index1) + list.get(index2)) / 2.0;
                }
                break;
            }
            k++;
        }

        return median;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
