/**
* lab 2 package
*/
package ki307.simchuk.lab2;

import java.util.*;
import java.io.*;
/**
 * Class <code>Scanner</code> implements scanner 
 */
public class Scanner{
	private String model;
    private int dpi;
    private boolean isDuplex;
    private boolean isTurnedOn;
    private PrintWriter logWriter;
    private static int totalDPI = 0;
	
    /**
     * Constructor 
     * @param <code>model</code> Model of the scanner
     * @param <code>dpi</code> Resolution of the document 
     * @param <code>isDuplex</code> Checks if can scan from both sides
     */
    public Scanner(String model, int dpi, boolean isDuplex) {
        this.model = model;
        this.dpi = dpi;
        this.isDuplex = isDuplex;
        this.isTurnedOn = false; 
        totalDPI += dpi;
    }
    
    public static int getTotalDPI() {
        return totalDPI;
    }
    
    /**
     * Method shows message into console if string is not empty
     * @param message
     */
    private void log(String message) {
        String logMessage = new Date() + " - " + message;
        System.out.println(logMessage);

        if (logWriter != null) {
            logWriter.println(logMessage);
        }
    }
    
    /**
     * Method that checks if scanner is turned on
     */
    public void turnOn() {
        isTurnedOn = true;
        log("Scanner turned on.");
    }
    
    /**
     * Method that checks if scanner is turned off
     */
    public void turnOff() {
        isTurnedOn = false;
        log("Scanner turned off.");
    }
    
    /**
     * Method for scanning document 
     * @param <code>filePath</code> scanned document
     */
    public void scanDocument(String inputFilePath, String outputFilePath) {
        if (!isTurnedOn) {
            log("Scanner is turned off. Cannot scan.");
            return;
        }

        File inputFile = new File(inputFilePath);
        if (!inputFile.isFile() || !inputFile.exists()) {
            log("Input file not found: " + inputFilePath);
            return;
        }

        File outputFile = new File(outputFilePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            log("Scanning document: " + inputFilePath);
            char[] buffer = new char[8192]; 

            int bytesRead;
            while ((bytesRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, bytesRead);
            }

            log("Document scanned and copied to: " + outputFilePath);
        } catch (IOException e) {
            log("Error scanning document: " + inputFilePath);
            e.printStackTrace();
        }
    }


    
    /**
     * Method which set resolution of the document 
     * @param <code>dpi</code> dots per inch
     */
    public void setDPI(int dpi) {
        this.dpi = dpi;
        log("DPI set to: " + dpi);
    }
    
    public int getDPI() {
    	return this.dpi;
    }
    
    /**
     * Method that set if the scanner is duplex
     * @param <code>isDuplex</code> scan from both sides
     */
    public void setDuplex(boolean isDuplex) {
        this.isDuplex = isDuplex;
        log("Duplex mode set to: " + isDuplex);
    }
    
    /**
     * Method that connects file where will be output
     * @param <code>logFilePath</code> path of file
     */
    public void connectToLogFile(String logFilePath) {
        try {
            logWriter = new PrintWriter(new FileWriter(logFilePath));
            log("Log file connected: " + logFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method which closing log file
     */
    public void closeLogFile() {
        if (logWriter != null) {
            logWriter.close();
            log("Log file closed.");
        }
    }
    
    
    
    
}

