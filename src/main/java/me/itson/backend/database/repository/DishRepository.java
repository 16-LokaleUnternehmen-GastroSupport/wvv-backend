package me.itson.backend.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.itson.backend.database.entity.Dish;

public interface DishRepository extends JpaRepository<Dish, String> {

	public List<Dish> findByLocationId(String locationId);
	
}
