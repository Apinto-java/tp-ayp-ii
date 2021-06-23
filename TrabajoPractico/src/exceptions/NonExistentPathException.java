package exceptions;

public class NonExistentPathException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3819710052388755010L;
	
	public NonExistentPathException() {
		
		super("No possible path");
	}
	
	public NonExistentPathException(String s) {
		
		super(s);
	}
	
}
