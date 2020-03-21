package me.itson.backend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.user.IomUser;
import me.itson.backend.dto.AccountDTO;
import me.itson.backend.exception.InvalidVerificationTokenException;
import me.itson.backend.security.user.IUserService;

@Service
public class AccountService {
	
	@Autowired
	private IUserService userService;
	
	public AccountDTO register(AccountDTO accountDto) {
		IomUser user = userService.registerNewUserAccount(accountDto);
		
		String token = generateRandomUuidToken();
		userService.createVerificationToken(user, UUID.randomUUID().toString());
		sendVerificationMail(user.getEmail(), token);
		
		return new AccountDTO(user);
	}
	
	public void verifyUser(String verificationToken) {
		IomUser user = userService.getUserByVerificationToken(verificationToken);
		if(user == null) {
			throw new InvalidVerificationTokenException();
		}
		
		user.setVerificationToken(null);
		userService.saveRegisteredUser(user);
	}
	
	private String generateRandomUuidToken() {
		return UUID.randomUUID().toString();
	}
	
	private void sendVerificationMail(String email, String token) {
		// TODO: Send Mail here (maybe Mailgun?)
	}
}
