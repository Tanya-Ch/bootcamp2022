class MagicSquareEven {

    public static void main (String[] args) {
        int n = 10;
        doublyEven(n);
    }

    static void doublyEven(int n) {
        int[][] arr = new int[n][n];
        int i, j;

        for ( i = 0; i < n; i++){
            for ( j = 0; j < n; j++) {
                arr[i][j] = (n * i) + j + 1;
            }
        }

        for ( i = 0; i < n/4; i++) {
            for (j = 0; j < n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        for ( i = 0; i < n/4; i++) {
            for (j = 3 * (n / 4); j < n; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        for ( i = 3 * n/4; i < n; i++) {
            for (j = 0; j < n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        for ( i = 3 * n/4; i < n; i++) {
            for (j = 3 * n / 4; j < n; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        for ( i = n/4; i < 3 * n/4; i++) {
            for (j = n / 4; j < 3 * n / 4; j++) {
                arr[i][j] = (n * n + 1) - arr[i][j];
            }
        }

        for (i = 0; i < n; i++)
        {
            for ( j = 0; j < n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}
 