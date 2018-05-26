package offtocol.domain.repository.reservation;


import java.util.List;

import offtocol.domain.model.*;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(ReservableRoomId reservableRoomId);

}
