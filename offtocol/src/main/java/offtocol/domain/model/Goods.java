package offtocol.domain.model;


import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;



@Entity
@Data
public class Goods implements Serializable {


	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer goodsId;

	private String name;

	private String description;

	private int price;

	@ManyToOne
	@JoinColumn(name = "house_id")
	private House house;


	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Goods)) {
			return false;
		}

		return goodsId.equals(
			((Goods) obj).getGoodsId()
		);

	}


	@Override
	public int hashCode() {
		return goodsId.hashCode();
	}


}
