package offtocol.domain.repository.room;


import java.time.LocalDate;
import java.util.List;

import offtocol.domain.model.*;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;



public interface ReservableRoomRepository
	extends JpaRepository<ReservableRoom, ReservableRoomId> {


	List<ReservableRoom> findByReservableRoomId_reservedDateAndMeetingRoom_house_houseId(LocalDate date, Integer houseId);


	@Lock(LockModeType.PESSIMISTIC_WRITE)
	ReservableRoom findOneForUpdateByReservableRoomId(ReservableRoomId reservableRoomId);


}
