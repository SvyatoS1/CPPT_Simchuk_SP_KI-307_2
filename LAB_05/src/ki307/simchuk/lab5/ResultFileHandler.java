/**
 * Package for LAB_05
 */
package ki307.simchuk.lab5;


import java.io.*;
import java.nio.*;
/**
 * Class which implement file with result
 */
public class ResultFileHandler {
	/**
	 * Method for write result in text file
	 * @param filePath name of the file
	 * @param result value that will be written
	 */
	public static void writeTextResult(String filePath, double result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Result: " + result);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
	/**
	 * Method for reading result for text file
	 * @param filePath name of the file
	 * @return zero if throws error
	 * @throws FileNotFoundException if file not find
	 * @throws IOException input output error
	 */
	public static double readTextResult(String filePath) throws FileNotFoundException, IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	String line = reader.readLine();
            if (line != null) {
                String resultString = line.replace("Result: ", "");
                return Double.parseDouble(resultString);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
       
        return 0.0;
    }
	/**
	 * Method for write result in binary file
	 * @param filePath name of the file
	 * @param result zero if throws error
	 */
	public static void writeBinaryResult(String filePath, double result) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filePath))) {
            dos.writeDouble(result);
        } catch (IOException e) {
            System.err.println("Error writing to binary file: " + e.getMessage());
        }
    }
	/**
	 * Method for reading result for binary file
	 * @param filePath name of the file
	 * @return zero if throws error
	 */
	public static double readBinaryResult(String filePath) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            return dis.readDouble();
        } catch (IOException e) {
            System.err.println("Error reading from binary file: " + e.getMessage());
        }
        return 0.0; 
    }
	
	public static String readFromFile(String filePath) throws IOException {
	    StringBuilder content = new StringBuilder();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            content.append(line).append("\n"); 
	        }
	    } catch (IOException e) {
	        System.err.println("Error reading from file: " + e.getMessage());
	    }
	    return content.toString();
	}

	
	public static void writeToFile(String filePath, String data) throws IOException {
	    try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
	        long fileLength = raf.length();
	        raf.seek(fileLength);
	        raf.write(data.getBytes());
	    } catch (IOException e) {
	        System.err.println("Error writing to file: " + e.getMessage());
	    }
	}

	
	
	
}