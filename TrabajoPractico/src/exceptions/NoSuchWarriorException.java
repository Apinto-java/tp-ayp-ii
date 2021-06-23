package exceptions;

public class NoSuchWarriorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoSuchWarriorException() {
		super("This Warrior does not exist");
	}
	
	public NoSuchWarriorException(String s) {
		super(s);
	}
	
}
