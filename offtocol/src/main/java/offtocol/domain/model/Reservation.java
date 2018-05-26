package offtocol.domain.model;


import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Objects;

import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class Reservation implements Serializable {



	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationId;


	//UUID
	private String uuid;


	@ManyToOne
	@JoinColumn(name = "username")
	private User user;


	@ManyToOne
	@JoinColumns(
		{
			@JoinColumn(name = "reserved_date"),
			@JoinColumn(name = "room_id")
		}
	)
	private ReservableRoom reservableRoom;


	private LocalTime startTime;


	private LocalTime endTime;


	private LocalDate reservationDate;



	public boolean overlap(Reservation target) {

		if(
			!Objects.equals(
				reservableRoom.getReservableRoomId(),
				target.reservableRoom.getReservableRoomId()
			)
		) {
			return false;
		}

		return startTime.equals(target.startTime);

	}



}
