package sort;

//排序算法
public class BaseSort {
    //冒泡排序
    public static int[] bubbleSort(int[] unorder) {
        if (unorder == null || unorder.length < 2) {
            return unorder;
        }
        for (int i = 0; i < unorder.length; i++) {
            for (int j = i; j < unorder.length - i - 1; j++) {
                if (unorder[j] > unorder[j + 1]) {
                    int temp = unorder[j];
                    unorder[j] = unorder[j + 1];
                    unorder[j + 1] = temp;
                }
            }
        }

        return unorder;
    }

    //选择排序
    public static int[] selectSort(int[] unorder) {
        if (unorder == null || unorder.length < 2) {
            return unorder;
        }
        for (int i = 0; i < unorder.length; i++) {
            for (int j = i + 1; j < unorder.length; j++) {
                if (unorder[i] > unorder[j]) {
                    int temp = unorder[i];
                    unorder[i] = unorder[j];
                    unorder[j] = temp;
                }
            }
        }

        return unorder;
    }

    //Insertion sort 插入排序
    public static int[] insertionSort(int[] unorder) {
        if (unorder == null || unorder.length < 2) {
            return unorder;
        }
        for (int i = 1; i < unorder.length; i++) {
            int temp = unorder[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (unorder[j] > temp) {
                    unorder[j + 1] = unorder[j];
                } else {
                    break;
                }
            }
            unorder[j + 1] = temp;

        }
        return unorder;
    }

    //希尔排序
    public static int[] shellSort(int[] unorder) {
        if (unorder == null || unorder.length < 2) {
            return unorder;
        }

        for (int k = unorder.length / 2; k > 0; k /= 2) {
            for (int i = k; i < unorder.length; i++) {
                int temp = unorder[i];
                int j = i - k;
                for (; j >= 0; j -= k) {
                    if (unorder[j] > temp) {
                        unorder[j + k] = unorder[j];
                    } else {
                        break;
                    }
                }
                unorder[j + k] = temp;

            }
        }

        return unorder;
    }

    public static void main(String[] args) {
        int[] unorder = new int[]{1, 6, 3, 5, 2, 9, 45, 4, 65, 98, 76};
        //int[] a = bubbleSort(unorder);
        //int[] a = selectSort(unorder);
        //int[] a = insertionSort(unorder);
        int[] a = shellSort(unorder);
        for (int i : a) {
            System.out.print(i + "\t");
        }

    }
}
