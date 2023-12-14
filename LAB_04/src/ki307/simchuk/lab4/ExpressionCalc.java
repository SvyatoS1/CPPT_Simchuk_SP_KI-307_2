/**
 * Package
 */
package ki307.simchuk.lab4;


/**
 * class to solve expression
 */
public class ExpressionCalc{
	
	public class Express extends Exception {
        public Express(String message) {
            super(message);
        }
    }
	/**
	 * 
	 * @param x parameter which we choose yourself for this equation
	 * @return result of the expression
	 * @throws ArithmeticException if denominator is zero
	 */
	public double calculateExpression(double x) throws ArithmeticException, Express {
        try {
            double numerator = Math.tan(x); // numerator of equation
            double denominator = Math.sin(4 * x) - 2 * Math.cos(x); // denominator of equation

            if (denominator == 0 || x==0) { // if denominator is zero throw exception
                throw new ArithmeticException("Division by zero is not allowed.");
            }else if(x>10){
            	throw new Express("Bigger than 10");
            }

            return numerator / denominator; // return result of equation
        } catch (ArithmeticException | Express e) {
        	if (e instanceof Express) {
                throw e;
            } else if (e instanceof ArithmeticException) {
            	throw e;
             
            }
        }
		return x;
    }
}
	



