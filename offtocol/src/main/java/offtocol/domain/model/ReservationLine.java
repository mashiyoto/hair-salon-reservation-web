package offtocol.domain.model;


import java.io.Serializable;

import lombok.Data;

import javax.persistence.*;



@Entity
@Data
public class ReservationLine implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer reservationLineId;

	//UUID
	private String uuid;

	@ManyToOne
	@JoinColumn(name = "goods_id")
	private Goods goods;


}
