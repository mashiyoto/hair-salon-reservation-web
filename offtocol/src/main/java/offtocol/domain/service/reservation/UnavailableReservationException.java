package offtocol.domain.service.reservation;



public class UnavailableReservationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnavailableReservationException(String message) {
		super(message);
	}

}
