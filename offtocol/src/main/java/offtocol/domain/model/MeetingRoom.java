package offtocol.domain.model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class MeetingRoom implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roomId;


	private String roomName;


	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;


}
