/**
 * Package for LAB_05
 */
package ki307.simchuk.lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Class Main which realize ResultFileHandler
 */
public class Main {
	/**
	 * Main method 
	 * @param args arguments
	 * @throws FileNotFoundException if file is not found
	 * @throws IOException input output error
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
        double result = 42.0; // Personalized Value

        // Test for text file 
        ResultFileHandler.writeTextResult("text_result.txt", result);
        double textResult = ResultFileHandler.readTextResult("text_result.txt");
        System.out.println("Text Result: " + textResult);

        // Test of binary format
        ResultFileHandler.writeBinaryResult("binary_result.bin", result);
        double binaryResult = ResultFileHandler.readBinaryResult("binary_result.bin");
        System.out.println("Binary Result: " + binaryResult);
        
        
        String sourceFilePath = "/Users/simch/eclipse-workspace/Lab01/MyFile.txt";
        String destinationFilePath = "Res.txt";

        try {
            String data = ResultFileHandler.readFromFile(sourceFilePath);
            ResultFileHandler.writeToFile(destinationFilePath, data);
            System.out.println("Data successfully read from and written to files.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        
    }
}