package offtocol.app.reservation;


import java.io.Serializable;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ReservationForm implements Serializable {


	private static final long serialVersionUID = 1L;


	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime startTime;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime endTime;


}
