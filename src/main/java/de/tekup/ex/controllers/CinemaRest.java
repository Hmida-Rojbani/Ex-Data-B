package de.tekup.ex.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.services.CinemaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CinemaRest {

	private CinemaService service;
	
	@GetMapping("/api/cinema/star/{name}/studios")
	public List<Studio> getStudioByStar(@PathVariable("name")String starName){
		return service.getSudiosByStar(starName);
	}
	
	@GetMapping("/api/cinema/studio/{name}/movie/color")
	public List<Movie> getColoredMovieByStudio(@PathVariable("name")String studioName){
		return service.getColoredMovieByStudio(studioName);
	}
	
	@GetMapping("/api/cinema/movie/{name}/like")
	public List<Movie> getStartOfMovie(@PathVariable("name")String preffix){
		return service.getMovieByNameDynmic(preffix);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
