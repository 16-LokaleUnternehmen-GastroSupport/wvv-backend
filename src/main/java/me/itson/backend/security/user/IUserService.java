package me.itson.backend.security.user;

import me.itson.backend.database.entity.user.IomUser;
import me.itson.backend.database.entity.user.IomVerificationToken;
import me.itson.backend.dto.AccountDTO;
import me.itson.backend.exception.EmailExistsException;
import me.itson.backend.exception.UsernameExistsException;

public interface IUserService {

	IomUser registerNewUserAccount(AccountDTO accountDto) throws EmailExistsException, UsernameExistsException;
	IomUser getUserByVerificationToken(String verificationToken);

	void saveRegisteredUser(IomUser user);
	void createVerificationToken(IomUser user, String token);

	IomVerificationToken getVerificationToken(String verificationToken);
}
