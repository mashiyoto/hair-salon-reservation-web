package offtocol.domain.service.user;


import offtocol.domain.model.User;



public interface UserService {

	User findByUsername(String username);

	void save(User user);

}
