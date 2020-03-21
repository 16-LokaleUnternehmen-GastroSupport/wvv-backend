package me.itson.backend.database.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.dto.AddressDTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	@Id
	private String id;

	@MapsId
	@OneToOne
	private Location location;
	
	private String street;
	private int streetNumber;
	
	private String zip;
	private String town;
	
	public Address(AddressDTO addressDto) {
		street = addressDto.getStreet();
		streetNumber = addressDto.getStreetNumber();
		zip = addressDto.getZip();
		town = addressDto.getTown();
	}
}
