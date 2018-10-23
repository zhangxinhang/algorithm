

public class ArrangeNumber {

    public static void arrange(int[] a) {

        innerArrange(a, 0);

    }

    private static void innerArrange(int[] a, int i) {
        if (i >= a.length) return;

        for (int j = 0; j < a.length; j++) {
            if (i == j) continue;
            printarr(a, i, j);
        }
        innerArrange(a, ++i);
    }

    private static void printarr(int[] a, int i, int j) {
        for (int k = 0; k < a.length; k++) {
            if (k == i) {
                System.out.print(a[j] + "\t");
                continue;
            }
            if (k == j) {
                System.out.print(a[i] + "\t");
                continue;
            }
            System.out.print(a[k] + "\t");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        arrange(a);
    }

}
