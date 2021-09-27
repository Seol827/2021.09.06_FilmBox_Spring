package com.film.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.film.dto.MovieDTO;

@Mapper
public interface MovieMapper {

	public List<MovieDTO> getMovieList();
	public void movieinsert(List<MovieDTO> mvList);
	public String updatedate();
	public void movieupdate(List<MovieDTO> mvList);
	public MovieDTO getMovie(String movieCd);
	public void updateList(List<MovieDTO> mvList);

}
