public class TEST {

    public static void main(String[] args) {
        TEST mt = new TEST();

        Thread t1 = new Thread(() -> mt.printEvenNumber(10));
        Thread t2 = new Thread(() -> mt.printOddNumber(5));

        t1.start();
        t2.start();
    }

//    M = n (n^2 + 1) / 2.
    public void printOddNumber(int n){
        synchronized (this) {
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

            System.out.println("The Magic Square for " + n + ": \n");
            System.out.println("Sum of each column or row " + n * (n * n + 1) / 2 + ": \n");

            for (i = 0; i < n; i++) {
                for ( j = 0; j < n; j++)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }
            System.out.println();

            notify();
        }
    }

    public void printEvenNumber(int n) {
        synchronized (this) {
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

            System.out.println("The Magic Square for " + n + ": \n");
            System.out.println("Sum of each column or row " + n * (n * n + 1) / 2 + ": \n");

            for (i = 0; i < n; i++) {
                for ( j = 0; j < n; j++)
                    System.out.print(arr[i][j]+" ");
                System.out.println();
            }
            System.out.println();

            notify();
        }
    }
}

