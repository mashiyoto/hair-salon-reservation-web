package offtocol.domain.model;


import java.io.Serializable;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;



@Data
public class CartRoomAndDate implements Serializable {


	private static final long serialVersionUID = 1L;


	private MeetingRoom room;

	private LocalDate date;

	private LocalTime startTime;

	private LocalTime endTime;


}
