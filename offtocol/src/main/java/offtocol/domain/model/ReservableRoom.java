package offtocol.domain.model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor //If a constructor including arguments is made, a default constructor isn't made automatically. This annotation is aded in order to make a default constructor.
public class ReservableRoom implements Serializable {


	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private ReservableRoomId reservableRoomId;

	@ManyToOne
	@JoinColumn(name = "room_id", insertable = false, updatable = false)
	@MapsId("roomId")
	private MeetingRoom meetingRoom;


	public ReservableRoom(ReservableRoomId reservableRoomId) {
		this.reservableRoomId = reservableRoomId;
	}


}
