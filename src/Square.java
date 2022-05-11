import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Square {
    public static void main(String[] args) throws IOException {
        int n = 5;
        Square square = new Square();
        square.makeSquare(n);
    }

    public void makeSquare(int s) throws IOException {
        int magicSqr[][] = new int[s][s];
        int x = s / 2;
        int y = s - 1;

        for (int i = 1; i <= s * s; ) {
            if (x == -1 && y == s) {
                y = s - 2;
                x = 0;
            } else {
                if (y == s) {
                    y = 0;
                }
                if (x < 0) {
                    x = s - 1;
                }
            }
            if (magicSqr[x][y] != 0) {
                y = y - 2;
                x = x + 1;
                continue;
            } else {
                magicSqr[x][y] = i;
                i = i + 1;
            }
            y = y + 1;
            x = x - 1;
        }

        String fileName = "MagicSqr.txt";

        File file = new File(fileName);
        if(file.createNewFile()){
            try(PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))){
                for (int i = -1; i < s + 1; i++) {
                    for (int j = 0; j < s; j++) {
                        if(i == -1 || i == s){
                            printWriter.print(" ");
                        } else {
                            printWriter.print(magicSqr[i][j] + "  ");
                        }
                    }
                    printWriter.println();
                }
            }
        }

        System.out.println("The Magic Square for " + s + ": \n");
        System.out.println("Sum of each column or row " + s * (s * s + 1) / 2 + ": \n");
        for (x = 0; x < s; x++) {
            for (y = 0; y < s; y++) {
                System.out.print(magicSqr[x][y] + " ");
            }
            System.out.println();
        }
    }
}
