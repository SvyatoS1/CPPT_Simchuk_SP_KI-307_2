package ki307.simchuk.lab3;

/**
 * class ScannedApp for demonstration of the working class MyScanner
 */
public class ScannedApp { 
	/**
	 * 
	 * @param args Main method to run application
	 */
    public static void main(String[] args) { 
        
        MyScanner myScanner = new MyScanner();

        
        myScanner.scanFile("input.txt");
        myScanner.copyFile("input.txt", "output.txt");
        myScanner.countSymb("input.txt");
    }
}