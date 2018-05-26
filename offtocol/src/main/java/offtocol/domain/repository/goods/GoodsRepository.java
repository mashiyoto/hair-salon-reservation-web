package offtocol.domain.repository.goods;


import org.springframework.data.jpa.repository.JpaRepository;
import offtocol.domain.model.Goods;
import java.util.List;



public interface GoodsRepository extends JpaRepository<Goods, Integer> {

	List<Goods> findByHouse_HouseId(Integer houseId);

	Goods findOne(Integer goodsId);

}
