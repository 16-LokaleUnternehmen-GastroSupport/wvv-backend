package me.itson.backend.database.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import me.itson.backend.database.entity.user.IomVerificationToken;

public interface IomVerificationTokenRepository extends JpaRepository<IomVerificationToken, String> {
	
	public IomVerificationToken findByToken(String token);
}
