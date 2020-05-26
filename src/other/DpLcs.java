package other;

public class DpLcs {

    public static int dplcs(String a, String b) {
        int[][] s = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) {
            s[i][0] = 0;
        }
        System.out.print(" \t");
        for (int j = 0; j <= b.length(); j++) {
            s[0][j] = 0;
            if (j < b.length())
                System.out.print(b.charAt(j) + "\t");
        }
        System.out.println();
        for (int k = 1; k <= a.length(); k++) {
            System.out.print(a.charAt(k - 1) + "\t");
            for (int l = 1; l <= b.length(); l++) {
                if ((a.charAt(k - 1) == b.charAt(l - 1))) {
                    s[k][l] = s[k - 1][l - 1] + 1;
                } else {
                    s[k][l] = Math.max(s[k - 1][l], s[k][l - 1]);
                }

                System.out.print(s[k][l] + "\t");
            }
            System.out.println();
        }


        return s[a.length()][b.length()];
    }

    public static void main(String[] args) {
        dplcs("abcd", "abcdabce");
    }
}
