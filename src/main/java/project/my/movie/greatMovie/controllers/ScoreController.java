package project.my.movie.greatMovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.my.movie.greatMovie.dto.MovieDTO;
import project.my.movie.greatMovie.dto.ScoreDTO;
import project.my.movie.greatMovie.services.ScoreService;


@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = this.scoreService.saveScore(dto);
		return movieDTO; 
	}
}
