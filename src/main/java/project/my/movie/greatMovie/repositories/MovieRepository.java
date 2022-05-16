package project.my.movie.greatMovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.my.movie.greatMovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
