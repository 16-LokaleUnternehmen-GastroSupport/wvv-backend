package me.itson.backend.rest;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.LocationDTO;

@RestController("location")
public class LocationEndpoint {

	@GetMapping("{zip:\\d+}")
	public List<LocationDTO> findLocationsByZip(@PathVariable String zip){
		throw new NotImplementedException("not implemented yet");
	}
	
}
