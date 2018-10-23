package sort;

import java.util.ArrayList;

public class RadixSort {


    public static void sort(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            ArrayList[] listarr = new ArrayList[10];
            for (int j = 0; j < a.length; j++) {
                int index = digindex(a[j], i, d);
                if (listarr[index] == null) {
                    listarr[index] = new ArrayList();
                }
                listarr[index].add(a[j]);
            }
            int newIndex = 0;
            for (int j = 0; j < listarr.length; j++) {
                if (listarr[j] != null) {
                    for (Object data : listarr[j]) {
                        a[newIndex++] = Integer.parseInt(data.toString());
                    }
                }
            }

        }

    }

    //求某一整数的某个位置的数字
    private static int digindex(int num, int index, int max) {
        // 3 1
        // System.out.println(String.format("%d=%d,%d,%d", a[i], a[i] / 100, a[i] % 100 / 10, a[i] % 100 % 10 / 1));
        for (int i = max; i > index + 1; i--) {
            num %= Math.pow(10, i - 1);
        }
        return new Double(num / Math.pow(10, index)).intValue();
    }

    public static void main(String[] args) {
        int[] a = new int[]{123, 34, 54, 67, 987, 345,1,555,23,998,8};
        sort(a, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.println(String.format("%d=%d,%d,%d", a[i], digindex(a[i], 2, 3),
                    digindex(a[i], 1, 3), digindex(a[i], 0, 3)));
        }


    }
}
