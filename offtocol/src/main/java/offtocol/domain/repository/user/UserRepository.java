package offtocol.domain.repository.user;


import org.springframework.data.jpa.repository.JpaRepository;

import offtocol.domain.model.User;



public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
