package me.itson.backend.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.database.entity.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

	@NotEmpty
	@NotNull
	private String street;

	@NotEmpty
	@NotNull
	private int streetNumber;
	
	@NotEmpty
	@NotNull
	private String zip;
	
	@NotEmpty
	@NotNull
	private String town;
	
	public AddressDTO(Address address) {
		street = address.getStreet();
		streetNumber = address.getStreetNumber();
		zip = address.getZip();
		town = address.getTown();
	}
}
