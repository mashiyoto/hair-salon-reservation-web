package offtocol.domain.service.goods;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import offtocol.domain.model.Goods;
import offtocol.domain.repository.goods.GoodsRepository;

import java.util.List;



@Service
public class GoodsService {


	@Autowired
	GoodsRepository goodsRepository;


	public List<Goods> listGoods(Integer houseId) {
		return goodsRepository.findByHouse_HouseId(houseId);
	}


	public Goods findOne(Integer goodsId) {
		return goodsRepository.findOne(goodsId);
	}


}
