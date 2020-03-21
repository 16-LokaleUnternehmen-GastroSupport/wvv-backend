package me.itson.backend.security.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.user.IomUser;
import me.itson.backend.database.repository.user.IomUserRepository;

@Service
public class IomUserDetailsService implements UserDetailsService {

	@Autowired
	private IomUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<IomUser> user = userRepository.findByUsername(username);

		if (!user.isPresent()) {
			throw new UsernameNotFoundException("User not found by name: " + username);
		}
		return toUserDetails(user.get());
	}

	private UserDetails toUserDetails(IomUser user) {
		return User.withUsername(user.getUsername()).password(user.getPassword()).roles("USER").build();
	}

}
