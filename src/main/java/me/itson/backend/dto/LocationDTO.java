package me.itson.backend.dto;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.itson.backend.database.entity.Location;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

	private String id;
	
	@NotEmpty
	@NotNull
	private String name;
	private AddressDTO address;
	private Set<AssetDTO> assets;
	
	public LocationDTO(Location location) {
		id = location.getId();
		name = location.getName();
		address = new AddressDTO(location.getAddress());
		assets = location.getAssets().stream().map(a -> new AssetDTO(a)).collect(Collectors.toSet());
	}
	
}
