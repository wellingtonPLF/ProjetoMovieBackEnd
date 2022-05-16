package project.my.movie.greatMovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.my.movie.greatMovie.entities.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{

}
