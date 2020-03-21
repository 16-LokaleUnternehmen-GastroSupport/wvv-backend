package me.itson.backend.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.itson.backend.database.entity.Location;

public interface LocationRepository extends JpaRepository<Location, String> {

	public List<Location> findByAddressZip(String zip);
	
}
