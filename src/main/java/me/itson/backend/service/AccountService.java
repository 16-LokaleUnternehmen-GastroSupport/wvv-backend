package me.itson.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.IomUser;
import me.itson.backend.database.repository.IomUserRepository;
import me.itson.backend.dto.AccountDTO;
import me.itson.backend.exception.EmailExistsException;

@Service
public class AccountService {
	
	@Autowired
	private IomUserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public AccountDTO register(AccountDTO accountDto) {
		if (emailExists(accountDto.getEmail())) {
	        throw new EmailExistsException(
	          "There is an account with that email adress:" + accountDto.getEmail());
	    }
		IomUser user = new IomUser();
		user.setUsername(accountDto.getUsername());
		user.setFirstname(accountDto.getFirstname());
		user.setLastname(accountDto.getLastname());
	     
	    user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
	     
	    user.setEmail(accountDto.getEmail());
	    return new AccountDTO(userRepository.save(user));
	}
	
	private boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
	}
}
