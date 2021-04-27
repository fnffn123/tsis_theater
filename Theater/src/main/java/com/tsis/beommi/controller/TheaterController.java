package com.tsis.beommi.controller;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsis.beommi.dto.Movie_Reservation;
import com.tsis.beommi.dto.Movie_Room;
import com.tsis.beommi.dto.Run_Movie;
import com.tsis.beommi.dto.Search_Reservation;
import com.tsis.beommi.service.TheaterService;
import com.tsis.beommi.dto.Search_Reservation;

import io.swagger.annotations.ApiOperation;


//http://localhost:8080/swagger-ui.html#/
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping(value="/theater", method= {RequestMethod.GET, RequestMethod.POST})
public class TheaterController {
   private static final Logger logger = LoggerFactory.getLogger(TheaterController.class);
    
   @Autowired
   private TheaterService theaterService;

   @ApiOperation(value = "모든 상영 목록", notes = "모든 영화 목록을 불러온다")
   @GetMapping("/run_movie")
   public ResponseEntity<List<Run_Movie>> getAllMoives() throws Exception {
      return new ResponseEntity<List<Run_Movie>>(theaterService.getMovies(), HttpStatus.OK);
   }
   @GetMapping("/picked_seats")
   public ResponseEntity<List<Movie_Reservation>> getPickedSeats(@Param("Movie_Reservation") Movie_Reservation movr) throws Exception{
	   return new ResponseEntity<List<Movie_Reservation>>(theaterService.getPickedSeats(movr),HttpStatus.OK);
   }
   @GetMapping("/get_movieroom")
   public ResponseEntity<List<Movie_Room>> getMovieRoom(@Param("Movie_Room") Movie_Room room) throws Exception{
	   return new ResponseEntity<List<Movie_Room>>(theaterService.getMovieRoom(room),HttpStatus.OK);
   }
   @GetMapping("/make_reservation")
   public int makeReservation(@Param("Movie_Reservation") Movie_Reservation movr) throws Exception{
	   System.out.println(movr.getOwner_NM());
	   theaterService.makeReservation(movr);
	   return 0;
   }
   @GetMapping("/get_reservation")
   public ResponseEntity<List<Search_Reservation>> getReservation(@Param("Search_Reservation") Search_Reservation sr) throws Exception{
	   System.out.println(sr.getOwner_NM());
	   return new ResponseEntity<List<Search_Reservation>>(theaterService.getReservation(sr),HttpStatus.OK);
   }

}