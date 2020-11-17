package de.tekup.ex.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import de.tekup.ex.data.models.Movie;
import de.tekup.ex.data.models.Star;
import de.tekup.ex.data.models.Studio;
import de.tekup.ex.data.repositories.MovieRepository;
import de.tekup.ex.data.repositories.StarRepository;
import de.tekup.ex.data.repositories.StudioRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CinemaServiceImpl implements CinemaService{
	
	private static List<Movie> movieTmp;
	private MovieRepository reposMovie;
	private StarRepository reposStar;
	private StudioRepository reposStudio;

	@Override
	public List<Studio> getSudiosByStar(String starName) {
		Star star = reposStar.findById(starName)
							.orElseThrow(()-> new NoSuchElementException("star with this name is not found"));
		/*Version 1
		 * Set<Studio> studios = new HashSet<>();
		for (Movie movie : star.getMovies()) {
			studios.add(movie.getStudio());
		}
		
		return new ArrayList<>(studios);*/
		//Version 2
		return star.getMovies().stream()
						.map(movie -> movie.getStudio())
						.distinct()
						.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getColoredMovieByStudio(String studioName) {
		Studio studio = reposStudio.findById(studioName)
				.orElseThrow(()-> new NoSuchElementException("studio with this name is not found"));
		/*
		List<Movie> movies = new ArrayList<>();
		
		for (Movie movie : studio.getMovies()) {
			if(movie.getColor() == 1)
				movies.add(movie);
		}
		
		return movies;
		*/
		return studio.getMovies()
				.stream()
				.filter(movie -> movie.getColor() == 1)
				.collect(Collectors.toList());
	}

	@Override
	public List<Movie> getMovieByNameDynmic(String preffixMovieName) {
		if(movieTmp == null)
			movieTmp = reposMovie.findAll();
		
		return movieTmp.stream()
					 .filter(m -> m.getTitle().startsWith(preffixMovieName))
					 .collect(Collectors.toList());
	}
	
	

}
