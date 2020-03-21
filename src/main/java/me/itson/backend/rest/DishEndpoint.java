package me.itson.backend.rest;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.DishDTO;

@RestController
@RequestMapping("dish")
public class DishEndpoint {

	@GetMapping
	public List<DishDTO> getDishesForLocation(@RequestParam(name = "locationId", required = true) String locationId) {
		throw new NotImplementedException("Method not implemented yet.");
	}
}
