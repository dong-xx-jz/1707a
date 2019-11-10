package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Movie;
import com.bw.entity.Type;

public interface MovieService {
	
	List<Movie> queryAll();

	List<Type> queryTypeList();

	Integer insertMovie(Movie movie);

	Integer insertMovieType(Map<String, Object> map);

	Movie queryMovieById(Integer mid);

	List<Type> queryMovieType(Integer mid);

	Integer deleteMovieType(Integer mid);

	Integer updateMovie(Movie movie);

}
