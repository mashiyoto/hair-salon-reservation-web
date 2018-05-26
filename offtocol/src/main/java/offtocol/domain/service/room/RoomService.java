package offtocol.domain.service.room;


import java.time.LocalDate;
import java.util.List;

import offtocol.domain.model.ReservableRoom;
import offtocol.domain.repository.room.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import offtocol.domain.model.MeetingRoom;
import offtocol.domain.repository.room.MeetingRoomRepository;



@Service
@Transactional
public class RoomService {


	@Autowired
	ReservableRoomRepository reservableRoomRepository;


	@Autowired
	MeetingRoomRepository meetingRoomRepository;


	public List<ReservableRoom> findReservableRooms(LocalDate date, Integer houseId) {
		return reservableRoomRepository.findByReservableRoomId_reservedDateAndMeetingRoom_house_houseId(date, houseId);
	}


	public MeetingRoom findMeetingRoom(Integer roomId) {
		return meetingRoomRepository.findOne(roomId);
	}

}
