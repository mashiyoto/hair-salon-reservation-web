package offtocol.app.confirm;



public class InvalidCartException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InvalidCartException(String message) {
		super(message);
	}

}
