/**
 * lab 2 package
 */
package ki307.simchuk.lab2;

/**
 * Scanner Application class implements main method for 
 * Scanner class abilities demonstration
 */
public class ScannerApp {

	/**
	 * @param args Demonstration of the scanner work
	 */
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner("Model X123", 300, true);
		main1();
		Scanner scanner2 = new Scanner("Model X123", 400, true);
		Scanner scanner3 = new Scanner("Model X123", 400, true);
		System.out.println("Total DPI: " + Scanner.getTotalDPI());
		/*scanner.connectToLogFile("scanner_log.txt");
	    scanner.turnOn();
	    scanner.scanDocument("Document1.txt", "Output1.txt"); 
	    scanner.scanDocument("Document2.txt", "Output2.txt"); 
	    scanner.scanDocument("Document3.txt", "Output3.txt"); 
        
	    scanner.setDPI(600);
	    scanner.setDuplex(false);
	    scanner.turnOff();
	    scanner.closeLogFile();*/

	    

	}

	public static void main1() {
		Scanner scanner1 = new Scanner("Model X123", 500, true);
	}
	
	

}
