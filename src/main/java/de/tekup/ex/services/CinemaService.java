package de.tekup.ex.services;

import java.util.List;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Studio;

public interface CinemaService {
	
	public List<Studio> getSudiosByStar(String starName);
	public List<Movie> getColoredMovieByStudio(String studioName);

}
