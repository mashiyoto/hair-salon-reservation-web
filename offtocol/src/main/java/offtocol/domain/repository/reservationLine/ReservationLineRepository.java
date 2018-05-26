package offtocol.domain.repository.reservationLine;


import java.util.List;

import offtocol.domain.model.*;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ReservationLineRepository extends JpaRepository<ReservationLine, Integer> {

	List<ReservationLine> findByUuid(String uuid);

}
