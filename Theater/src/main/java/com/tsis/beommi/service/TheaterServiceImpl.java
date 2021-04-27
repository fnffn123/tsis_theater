package com.tsis.beommi.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsis.beommi.dao.TheaterDAO;
import com.tsis.beommi.dto.Movie_Reservation;
import com.tsis.beommi.dto.Movie_Room;
import com.tsis.beommi.dto.Run_Movie;
import com.tsis.beommi.dto.Search_Reservation;

@Service
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private TheaterDAO theaterdao;
	
	@Override
	public List<Run_Movie>getMovies(){
		return theaterdao.getMovies();
	}
	
	@Override
	public List<Movie_Reservation> getPickedSeats(Movie_Reservation movr){
		return theaterdao.getPickedSeats(movr);
	}
	@Override
	public List<Movie_Room>getMovieRoom(Movie_Room room){
		return theaterdao.getMovieRoom(room);
	}
	@Override
	public void makeReservation(Movie_Reservation movr){
		theaterdao.makeReservation(movr);
	}
	@Override
	public List<Search_Reservation> getReservation(Search_Reservation movr){
		return theaterdao.getReservation(movr);
	}

}
