package game;

public class OwnTownException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -958365733896872350L;
	
	public OwnTownException() {
		super("There's already an owned Town");
	}

}
