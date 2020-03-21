package me.itson.backend.rest;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.LocationDTO;

@RestController
@RequestMapping("location")
public class LocationEndpoint {
	
	@GetMapping("{id:[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}}")
	public List<LocationDTO> getLocation(@PathVariable String id){
		throw new NotImplementedException("not implemented yet");
	}
	
	@PostMapping
	public LocationDTO createLocation(@RequestBody LocationDTO locationDto){
		throw new NotImplementedException("not implemented yet");
	}

	@GetMapping("top")
	public List<LocationDTO> findTopLocations(){
		throw new NotImplementedException("not implemented yet");
	}
	
	@GetMapping("{zip:\\d+}")
	public List<LocationDTO> findLocationsByZip(@PathVariable String zip){
		throw new NotImplementedException("not implemented yet");
	}
	
	@GetMapping("{zip:\\d+}/top")
	public List<LocationDTO> findTopLocationsByZip(@PathVariable String zip){
		throw new NotImplementedException("not implemented yet");
	}

}
