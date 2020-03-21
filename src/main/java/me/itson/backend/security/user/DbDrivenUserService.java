package me.itson.backend.security.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.user.IomUser;
import me.itson.backend.database.entity.user.IomVerificationToken;
import me.itson.backend.database.repository.user.IomUserRepository;
import me.itson.backend.database.repository.user.IomVerificationTokenRepository;
import me.itson.backend.dto.AccountDTO;
import me.itson.backend.exception.EmailExistsException;
import me.itson.backend.exception.UsernameExistsException;

@Service
public class DbDrivenUserService implements IUserService {
	
	@Autowired
	private IomUserRepository userRepository;
	@Autowired
	private IomVerificationTokenRepository tokenRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Override
	public boolean validateCredentials(String username, String password) {
		Optional<IomUser> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			return passwordEncoder.matches(password, user.get().getPassword());
		}
		return false;
	}
	
	@Override
	public IomUser registerNewUserAccount(AccountDTO accountDto) throws EmailExistsException, UsernameExistsException {
		if (emailExists(accountDto.getEmail())) {
	        throw new EmailExistsException(
	          "There is an account with that email adress:" + accountDto.getEmail());
	    }
		if(usernameExists(accountDto.getUsername())) {
			throw new UsernameExistsException();
		}
		IomUser user = new IomUser();
		user.setUsername(accountDto.getUsername());
		user.setFirstname(accountDto.getFirstname());
		user.setLastname(accountDto.getLastname());
	     
	    user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
	     
	    user.setEmail(accountDto.getEmail());
	    return userRepository.save(user);
	}

	@Override
	public IomUser getUserByVerificationToken(String verificationToken) {
		return userRepository.findByVerificationTokenToken(verificationToken);
	}

	@Override
	public void saveRegisteredUser(IomUser user) {
		userRepository.save(user);
	}

	@Override
	public void createVerificationToken(IomUser user, String token) {
		IomVerificationToken verificationToken = IomVerificationToken.builder().token(token).user(user).build();
		tokenRepository.save(verificationToken);
	}

	@Override
	public IomVerificationToken getVerificationToken(String verificationToken) {
		return tokenRepository.findByToken(verificationToken);
	}

	
	private boolean emailExists(String email) {
		return userRepository.existsByEmail(email);
	}
	private boolean usernameExists(String username) {
		return userRepository.existsByUsername(username);
	}

}
