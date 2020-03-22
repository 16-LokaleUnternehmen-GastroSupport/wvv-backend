package me.itson.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.itson.backend.database.entity.Dish;
import me.itson.backend.database.repository.DishRepository;
import me.itson.backend.dto.DishDTO;

@Service
public class DishService {

	@Autowired
	private DishRepository dishRepository;
	
	public DishDTO createDish(DishDTO dishDto) {
		Dish newDish = new Dish(dishDto);
		newDish.setId(null);
		return new DishDTO(dishRepository.save(newDish));
	}
	
	public List<DishDTO> getDishesForLocation(String locationId){
		return dishRepository.findByLocationId(locationId).stream().map(d -> new DishDTO(d)).collect(Collectors.toList());
	}
	
	public void deleteDish(String dishId) {
		Dish dish = dishRepository.findById(dishId).orElseThrow(() -> new ObjectNotFoundException(dishId, "Dish"));
		dishRepository.deleteById(dishId);
	}
}
