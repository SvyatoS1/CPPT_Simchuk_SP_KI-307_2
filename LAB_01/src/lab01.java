import java.io.*;
import java.util.*;
/**
 * Class that implements work with array
 */
public class lab01{
	/**
	 * Main method
	 * @param args arguments
	 * @throws FileNotFoundException if file MyFile.txt does not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in); // scan the symbols from keyboard
        File dataFile = new File("MyFile.txt"); // file where result will print
        PrintWriter fout = new PrintWriter(dataFile); // print into file 

        System.out.print("Введіть розмір квадратної матриці: ");
        int nRows = in.nextInt(); // rows of the matrix
        in.nextLine();

        char[][] arr = new char[nRows][nRows]; // square matrix with nRows size

        System.out.print("\nВведіть символ-заповнювач: ");
        String filler = in.nextLine(); // read from keyboard symbol of filler
        
        System.out.print("\nВведіть символ-заповнювач2: ");
        String filler2 = in.nextLine(); // read from keyboard symbol of filler

        if (filler.length() != 1) { // if user write not a char - print error
            System.out.println("Символ-заповнювач введено невірно.");
            System.exit(1);
        }
        /**
         * Fill of the array
         */
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (i == 0 || i == nRows - 1 || j == 0 || j == nRows - 1) {
                    arr[i][j] = filler2.charAt(0);
                }else if((i >= nRows / 4 && i < 3 * nRows / 4 && j >= nRows / 4 && j < 3 * nRows / 4)) {
                	arr[i][j] = filler.charAt(0);
                }
                	
                else {
                    arr[i][j] = ' ';
                }
            }
        }
        /**
         * Print array
         */
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                System.out.print(arr[i][j] + " ");
                fout.print(arr[i][j] + " ");
            }
            System.out.println();
            fout.println();
        }

        fout.flush();
        fout.close();

    }
}