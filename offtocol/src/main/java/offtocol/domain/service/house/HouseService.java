package offtocol.domain.service.house;


import offtocol.domain.model.*;
import offtocol.domain.repository.house.HouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class HouseService {


	@Autowired
	HouseRepository houseRepository;


	public List<House> findAll() {
		return houseRepository.findAll();
	}


	public House findHouse(Integer houseId) {
		return houseRepository.findOne(houseId);
	}


}
