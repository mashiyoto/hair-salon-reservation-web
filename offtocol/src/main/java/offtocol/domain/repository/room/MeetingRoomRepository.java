package offtocol.domain.repository.room;


import org.springframework.data.jpa.repository.JpaRepository;

import offtocol.domain.model.MeetingRoom;



public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Integer> {

}
