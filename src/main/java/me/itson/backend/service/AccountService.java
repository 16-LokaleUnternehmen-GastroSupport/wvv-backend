package me.itson.backend.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import me.itson.backend.database.entity.user.IomUser;
import me.itson.backend.dto.AccountDTO;
import me.itson.backend.exception.InvalidCredentialException;
import me.itson.backend.exception.InvalidVerificationTokenException;
import me.itson.backend.security.user.IUserService;

@Log4j2
@Service
public class AccountService {
	
	@Autowired
	private IUserService userService;
	
	public void login(AccountDTO accountDto) {
		boolean authSuccess = userService.validateCredentials(accountDto.getUsername(), accountDto.getPassword());
		if (!authSuccess) {
			throw new InvalidCredentialException();
		}
	}
	
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
		log.info("Sending E-Mail with Token [{}] to E-Mail [{}]", token, email);
	}
}
