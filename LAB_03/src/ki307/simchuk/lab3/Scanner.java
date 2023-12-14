/**
 * used package
 */
package ki307.simchuk.lab3;

import java.io.*;

/**
 * Implement interface Scannable which checks if input file exists
 */
interface Scannable 
{
	void scanFile(String filePath);
}

interface Scannable1{
	void countSymb (String filePath);
}
/**
 * Abstract class Scanner define copyFile method
 */
public abstract class Scanner {
	public abstract void copyFile(String sourceFilePath, String destinationFilePath); // abstract method for copying file
	

}
/**
 * MyScanner implements interface Scannable and extends Scanner superclass
 */
class MyScanner extends Scanner implements Scannable, Scannable1{
	@Override
	public void copyFile(String sourceFilePath, String destinationFilePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath)); // for reading content from file
	             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) { // for writing content in file 

	            System.out.println("Copying content from " + sourceFilePath + " to " + destinationFilePath); // marker that say that data copying

	            String line;
	            while ((line = reader.readLine()) != null) { // read source file line by line
	                writer.write(line);
	                writer.newLine(); 
	            }

	            System.out.println("Content copied successfully.");  // marker about successfull copying

	        } catch (IOException e) {
	            System.err.println("Error copying content: " + e.getMessage());  // marker about failing copying
	        }
	}
	
	@Override
	public void scanFile(String filePath) {
		File inputFile = new File(filePath);
	    if (!inputFile.exists() || !inputFile.isFile()) {
	        System.out.println("No input file found: " + filePath);
	    } else {
	        System.out.println("Input file exists: " + filePath);

	        try {
	            // Read the content of the file and print it line by line
	            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	            reader.close();
	        } catch (IOException e) {
	            System.err.println("An error occurred while reading the file: " + e.getMessage());
	        }
	    }
    }
	
	@Override
	public void countSymb(String filePath) {
		File inputFile = new File(filePath);
	    if (!inputFile.exists() || !inputFile.isFile()) {
	        System.out.println("No input file found: " + filePath);
	    } else {
	        System.out.println("Input file exists: " + filePath);
	        try {
	            int symbolCount = 0;  // Initialize a counter for symbols

	            // Read the content of the file, count symbols, and print it line by line
	            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	                symbolCount += line.length();
	            }
	            reader.close();

	            // Output the total symbol count to the console
	            System.out.println("Total symbol count: " + symbolCount);
	        } catch (IOException e) {
	            System.err.println("An error occurred while reading the file: " + e.getMessage());
	        }
	    }
	}
}