package project.my.movie.greatMovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.my.movie.greatMovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail(String email);
}
