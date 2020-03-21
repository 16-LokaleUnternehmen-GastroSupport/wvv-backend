package me.itson.backend.rest;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.LocationDTO;
import me.itson.backend.service.LocationService;

@RestController
@RequestMapping("location")
public class LocationEndpoint {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("{id:[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}}")
	public LocationDTO getLocation(@PathVariable String id){
		return locationService.getLocation(id);
	}
	
	@PostMapping
	public LocationDTO createLocation(@RequestBody LocationDTO locationDto){
		return locationService.createLocation(locationDto);
	}

	@GetMapping("top")
	public List<LocationDTO> findTopLocations(){
		throw new NotImplementedException("not implemented yet");
	}
	
	@GetMapping("{zip:\\d+}")
	public List<LocationDTO> findLocationsByZip(@PathVariable String zip){
		return locationService.getLocationsForZip(zip);
	}
	
	@GetMapping("{zip:\\d+}/top")
	public List<LocationDTO> findTopLocationsByZip(@PathVariable String zip){
		throw new NotImplementedException("not implemented yet");
	}

}
