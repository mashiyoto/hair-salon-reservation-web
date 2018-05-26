package offtocol.domain.service.reservation;


public class AlreadyReservedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AlreadyReservedException(String message) {
		super(message);
	}

}
