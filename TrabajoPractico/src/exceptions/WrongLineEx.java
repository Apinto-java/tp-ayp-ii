package exceptions;

public class WrongLineEx extends Exception {

	private static final long serialVersionUID = 1L;
	
	public WrongLineEx() {
		super("Line is invalid or empty.");
	}
	
	public WrongLineEx(String s) {
		super(s);
	}
	
}
