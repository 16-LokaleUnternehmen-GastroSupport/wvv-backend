package me.itson.backend.database.entity.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IomVerificationToken {

	@Id
	private String id;

	@NotEmpty
	@NotNull
	private String token;
	
	@OneToOne
	@MapsId
	private IomUser user;
	
}
