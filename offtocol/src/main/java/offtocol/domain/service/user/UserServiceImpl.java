package offtocol.domain.service.user;


import offtocol.domain.model.User;
import offtocol.domain.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepository userRepository;


	@Autowired
	private BCryptPasswordEncoder encoder;


	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}


}
