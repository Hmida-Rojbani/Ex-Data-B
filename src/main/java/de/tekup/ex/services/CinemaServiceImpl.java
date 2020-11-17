package de.tekup.ex.services;

import java.util.List;

import org.springframework.stereotype.Service;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.data.repositories.MovieRepository;
import de.tekup.ex.data.repositories.StarRepository;
import de.tekup.ex.data.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService{
	
	private MovieRepository reposMovie;
	private StarRepository reposStar;
	private StudioRepository reposStudio;

	@Override
	public List<Studio> getSudiosByStar(String starName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getColoredMovieByStudio(String studioName) {
		// TODO Auto-generated method stub
		return null;
	}

}
