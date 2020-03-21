package me.itson.backend.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.itson.backend.database.entity.IomUser;

public interface IomUserRepository extends JpaRepository<IomUser, String> {

	public boolean existsByEmail(String email);
	public Optional<IomUser> findByUsername(String username);
	
}
