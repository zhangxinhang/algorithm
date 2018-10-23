package sort;

public class QuickSort {

    public static void quicksort(int[] a) {
        quickSortInternally(a, 0, a.length - 1);
    }

    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) return;

        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);

    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p, j = p;
        for (; j < r; j++) {
            //通过i标记分位，最后只需要调换该位即可。
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }

        }
        a[r] = a[i];
        a[i] = pivot;
        System.out.println(i);

        return i;
    }

    public static void main(String[] args) {
        int[] unorder = new int[]{1, 6, 3, 5, 2, 9, 45, 4, 65, 98, 76};

        quicksort(unorder);
        for (int i : unorder) {
            System.out.print(i + "\t");
        }

    }

}
