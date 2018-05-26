package offtocol.domain.service.user;


import offtocol.domain.model.User;
import offtocol.domain.repository.user.UserRepository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;



@Service
public class ReservationUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user==null) {
			throw new UsernameNotFoundException(
				username + " is not found."
			);
		}

		return new ReservationUserDetails(user);

	}

}
