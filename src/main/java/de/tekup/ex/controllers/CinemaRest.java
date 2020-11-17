package de.tekup.ex.controllers;

import java.util.List;

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
}
