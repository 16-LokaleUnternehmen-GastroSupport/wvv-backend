package me.itson.backend.database.repository.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.itson.backend.database.entity.user.IomUser;

public interface IomUserRepository extends JpaRepository<IomUser, String> {

	public boolean existsByEmail(String email);
	public boolean existsByUsername(String username);
	public Optional<IomUser> findByUsername(String username);
	public IomUser findByVerificationTokenToken(String verificationToken);
	
}
