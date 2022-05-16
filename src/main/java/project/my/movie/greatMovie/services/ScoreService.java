package project.my.movie.greatMovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.my.movie.greatMovie.dto.MovieDTO;
import project.my.movie.greatMovie.dto.ScoreDTO;
import project.my.movie.greatMovie.entities.Movie;
import project.my.movie.greatMovie.entities.Score;
import project.my.movie.greatMovie.entities.User;
import project.my.movie.greatMovie.repositories.MovieRepository;
import project.my.movie.greatMovie.repositories.ScoreRepository;
import project.my.movie.greatMovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto){
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = this.userRepository.saveAndFlush(user);
		}
		
		Movie movie = this.movieRepository.findById(dto.getMovieId()).get();
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}
		
		double avg = sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		movie = this.movieRepository.save(movie);
		return new MovieDTO(movie);
	}
}
