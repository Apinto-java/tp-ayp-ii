package exceptions;

public class NoSuchAlignmentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -267684893036006605L;
	
	public NoSuchAlignmentException() {
		super("The alignment does not exist");
	}
	
	public NoSuchAlignmentException(String s) {
		super(s);
	}
	
}
