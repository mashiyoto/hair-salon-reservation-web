package offtocol.domain.model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class House implements Serializable {


	private static final long serialVersionUID = 1L;


	public enum NationName {
		JPN, USA, GBR, CAN, AUS, NZL
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer houseId;


	private String houseName;


	@Enumerated(EnumType.STRING)
	private NationName nationName;


	private String location;


}
