package offtocol.domain.service.reservation;


import java.util.List;

import offtocol.domain.model.*;
import offtocol.domain.repository.reservation.ReservationRepository;
import offtocol.domain.repository.room.ReservableRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ReservationService {



	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	ReservableRoomRepository reservableRoomRepository;



	public Reservation findReservation(Integer reservationId) {
		return reservationRepository.findOne(reservationId);
	}



	public List<Reservation> findReservations(ReservableRoomId reservableRoomId) {

		return reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId);

	}



	public List<Reservation> showReservationsAtDashboard(String username) {

		return reservationRepository.findByUser_Username(username);

	}



	public void reserve(Reservation reservation) {
		reservationRepository.save(reservation);
	}



	public void check(Reservation reservation) {


		ReservableRoomId reservableRoomId = reservation.getReservableRoom().getReservableRoomId();


		//Pessimistic Lock
		//Check if the stylist is reservable
		ReservableRoom reservableRoom = reservableRoomRepository.findOneForUpdateByReservableRoomId(reservableRoomId);

		if(reservableRoom == null) {
			throw new UnavailableReservationException("You cannot reserve this stylist on this date.");
		}


		//Check if the time zone is reservable
		boolean overlap =
			reservationRepository.findByReservableRoom_ReservableRoomIdOrderByStartTimeAsc(reservableRoomId)
			.stream()
			.anyMatch(
				x -> x.overlap(reservation)
			);

		if(overlap) {
			throw new AlreadyReservedException("This time zone was reserved.");
		}


	}



	public Reservation findOne(Integer reservationId) {
		return reservationRepository.findOne(reservationId);
	}



}
