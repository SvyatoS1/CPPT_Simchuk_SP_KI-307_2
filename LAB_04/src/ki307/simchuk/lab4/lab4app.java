/**
 * package of Lab_04
 */
package ki307.simchuk.lab4;


import java.io.*;

import ki307.simchuk.lab4.ExpressionCalc.Express;
/**
 * Class to demonstrate a work of code 
 */
public class lab4app{
	

	/**
	 * Main method
	 * @param args arguments of main method
	 * @throws Express 
	 */
	public static void main(String[] args) throws Express {
        try {
            ExpressionCalc calculator = new ExpressionCalc(); // new object of class
            double x = 2; // personalized value

            double result = calculator.calculateExpression(x); // result of method 

            /**
             * Write result into result.txt
             */
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"))) {
                writer.write("Result: " + result);
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}