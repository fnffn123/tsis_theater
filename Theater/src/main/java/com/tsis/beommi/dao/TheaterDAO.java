package com.tsis.beommi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tsis.beommi.dto.Movie_Reservation;
import com.tsis.beommi.dto.Movie_Room;
import com.tsis.beommi.dto.Run_Movie;
import com.tsis.beommi.dto.Search_Reservation;
@Mapper
public interface TheaterDAO {
	public List<Run_Movie>getMovies();
	public List<Movie_Reservation> getPickedSeats(Movie_Reservation movr);
	public List<Search_Reservation>getReservation(Search_Reservation movr);
	public List<Movie_Room>getMovieRoom(Movie_Room room);
	public void makeReservation( Movie_Reservation movr);
}
