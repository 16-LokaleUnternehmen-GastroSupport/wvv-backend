package me.itson.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.Location;
import me.itson.backend.database.repository.LocationRepository;
import me.itson.backend.dto.LocationDTO;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public LocationDTO getLocation(String id) {
		return new LocationDTO(
				locationRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "Location")));
	}

	public LocationDTO createLocation(LocationDTO locationDto) {
		Location location = new Location(locationDto);
		location.setId(null);

		return new LocationDTO(locationRepository.save(location));
	}

	public LocationDTO updateLocation(LocationDTO locationDto) {
		throw new NotImplementedException("Method not implemented yet.");
	}

	public List<LocationDTO> getLocationsForZip(String zip) {
		return locationRepository.findByAddressZip(zip).stream().map(l -> new LocationDTO(l))
				.collect(Collectors.toList());
	}

}
