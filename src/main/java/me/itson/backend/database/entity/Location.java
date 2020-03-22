package me.itson.backend.database.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.dto.LocationDTO;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3012937771744417228L;

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	private String name;

	@OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
	private Address address;

	
	@OneToMany(mappedBy = "location")
	private Set<Dish> dishes;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Asset> assets;
	

	public Location(LocationDTO locationDto) {
		id = locationDto.getId();
		name = locationDto.getName();
		address = new Address(locationDto.getAddress());
		address.setLocation(this);
		assets = locationDto.getAssets() == null ? Collections.emptySet()
				: locationDto.getAssets().stream().map(a -> new Asset(a)).collect(Collectors.toSet());
	}
}
