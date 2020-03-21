package me.itson.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.database.entity.user.IomUser;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	private String username;
	private String email;
	private String password;
	
	private String firstname;
	private String lastname;

	
	public AccountDTO(IomUser user) {
		username = user.getUsername();
		email = user.getEmail();
		firstname = user.getFirstname();
		lastname = user.getLastname();
	}
}
