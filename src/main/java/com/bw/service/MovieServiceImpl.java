package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Movie;
import com.bw.entity.Type;
import com.bw.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Resource
	private MovieMapper mapper;

	public List<Movie> queryAll() {
		// TODO Auto-generated method stub
		return mapper.queryAll();
	}

	public List<Type> queryTypeList() {
		// TODO Auto-generated method stub
		return mapper.queryTypeList();
	}

	public Integer insertMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mapper.insertMovie(movie);
	}

	public Integer insertMovieType(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return mapper.insertMovieType(map);
	}

	public Movie queryMovieById(Integer mid) {
		// TODO Auto-generated method stub
		return mapper.queryMovieById(mid);
	}

	public List<Type> queryMovieType(Integer mid) {
		// TODO Auto-generated method stub
		return mapper.queryMovieType(mid);
	}

	public Integer deleteMovieType(Integer mid) {
		// TODO Auto-generated method stub
		return mapper.deleteMovieType(mid);
	}

	public Integer updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return mapper.updateMovie(movie);
	}

}
