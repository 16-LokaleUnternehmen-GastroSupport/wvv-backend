package me.itson.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.itson.backend.dto.DishDTO;
import me.itson.backend.service.DishService;

@RestController
@RequestMapping("dish")
public class DishEndpoint {
	
	@Autowired
	private DishService dishService;

	@GetMapping
	public List<DishDTO> getDishesForLocation(@RequestParam(name = "locationId", required = true) String locationId) {
		return dishService.getDishesForLocation(locationId);
	}

	@PostMapping()
	public DishDTO createDish(@RequestBody DishDTO dishDto) {
		return dishService.createDish(dishDto);
	}
	
	@DeleteMapping("{id:[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}}")
	public void deleteDish(@PathVariable String id) {
		dishService.deleteDish(id);
	}
}
