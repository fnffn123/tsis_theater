package com.tsis.beommi.dto;

// RUN_MOVIE_ROOM_NUM,MOVIE_NM,RUN_MOVIE_ST_TIME,SEAT_NUM
public class Search_Reservation {
	private int run_MOVIE_ROOM_NUM;
	private String MOVIE_NM;
	public String getMOVIE_NM() {
		return MOVIE_NM;
	}
	public void setMOVIE_NM(String mOVIE_NM) {
		MOVIE_NM = mOVIE_NM;
	}
	private String run_MOVIE_ST_TIME;
	private String seat_NUM;
	private String phone_NUM;
	private String owner_NM;
	private int run_MOVIE_ID;
	public int getRun_MOVIE_ROOM_NUM() {
		return run_MOVIE_ROOM_NUM;
	}
	public void setRun_MOVIE_ROOM_NUM(int run_MOVIE_ROOM_NUM) {
		this.run_MOVIE_ROOM_NUM = run_MOVIE_ROOM_NUM;
	}

	public String getRun_MOVIE_ST_TIME() {
		return run_MOVIE_ST_TIME;
	}
	public void setRun_MOVIE_ST_TIME(String run_MOVIE_ST_TIME) {
		this.run_MOVIE_ST_TIME = run_MOVIE_ST_TIME;
	}
	public String getSeat_NUM() {
		return seat_NUM;
	}
	public void setSeat_NUM(String seat_NUM) {
		this.seat_NUM = seat_NUM;
	}
	public String getPhone_NUM() {
		return phone_NUM;
	}
	public void setPhone_NUM(String phone_NUM) {
		this.phone_NUM = phone_NUM;
	}
	public String getOwner_NM() {
		return owner_NM;
	}
	public void setOwner_NM(String owner_NM) {
		this.owner_NM = owner_NM;
	}
	public int getRun_MOVIE_ID() {
		return run_MOVIE_ID;
	}
	public void setRun_MOVIE_ID(int run_MOVIE_ID) {
		this.run_MOVIE_ID = run_MOVIE_ID;
	}

	
	

	
	
}
