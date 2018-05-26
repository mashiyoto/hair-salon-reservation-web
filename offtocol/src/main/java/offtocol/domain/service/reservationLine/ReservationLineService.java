package offtocol.domain.service.reservationLine;


import offtocol.domain.model.*;
import offtocol.domain.repository.reservationLine.ReservationLineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class ReservationLineService {


	@Autowired
	ReservationLineRepository reservationLineRepository;


	public void reserve(ReservationLine reservationLine) {
		reservationLineRepository.save(reservationLine);
	}


	public List<ReservationLine> showReservationLines(String uuid) {
		return reservationLineRepository.findByUuid(uuid);
	}


}
