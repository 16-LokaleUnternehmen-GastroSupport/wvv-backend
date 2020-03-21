package me.itson.backend.database.entity.user;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class IomUser {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;

	@NotNull
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message ="email format invalid")
	private String email;
	
	@NotNull
    @NotEmpty
	private String username;
	
	@NotNull
    @NotEmpty
	private String password;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private IomVerificationToken verificationToken;
	
	private String firstname;
	private String lastname;

}
