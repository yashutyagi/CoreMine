package exception;

public class ExceptionRethrow {
	public void methodA() throws CheckedException {
		System.out.println("Method A Called");
		throw new CheckedException("Custom exception Thrown");
	}

	public void methodB() throws Exception {
		try {
			System.out.println("Method B Called");
			methodA();
		} catch (CheckedException e) {
			System.out.println("Catch of methodB");
			e.printStackTrace();
			throw e;
		}
	}

	public void methodC() throws Exception {
		try {
			System.out.println("Method C Called");
			methodA();
		} catch (CheckedException e) {
			System.out.println("Catch of methodC");
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static void main(String[] args) {
		ExceptionRethrow rethrow = new ExceptionRethrow();
		try {
			rethrow.methodB();
		} catch (Exception e) {
			System.out.println("In main Catch");
			e.printStackTrace();
		}
	}
}
/**
 * Method B Called
 * Method A Called
 * Catch of methodB
 * StackTrace Line 6  to Line 26
 * In main Catch
 * Same Stack trace will be printed
 * 
 * 
 * Method C Called
 * Method A Called
 * Catch of methodB
 * StackTrace Line 6  to Line 26
 * In main Catch
 * Different Stack trace will be printed
 * Origination will be line 27
 * 
 * 
 *
 */

class CheckedException extends Exception {

	public CheckedException(String cause) {
		super(cause);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
