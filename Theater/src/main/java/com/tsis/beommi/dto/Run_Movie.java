package com.tsis.beommi.dto;

public class Run_Movie {
	private int RUN_MOVIE_ID;
	private String MOVIE_NM;
	private String RUN_MOVIE_PRICE;
	private String RUN_MOVIE_ST_TIME;
	private String RUN_MOVIE_RUNTIME;
	private String RUN_MOVIE_ROOM_NUM;
	private int RUN_MOVIE_ROOM_SEATS;
	@Override
	public String toString() {
		return "Run_Movie [RUN_MOVIE_ID=" + RUN_MOVIE_ID + ", MOVIE_NM=" + MOVIE_NM + ", RUN_MOVIE_PRICE="
				+ RUN_MOVIE_PRICE + ", RUN_MOVIE_ST_TIME=" + RUN_MOVIE_ST_TIME + ", RUN_MOVIE_RUNTIME="
				+ RUN_MOVIE_RUNTIME + ", RUN_MOVIE_ROOM_NUM=" + RUN_MOVIE_ROOM_NUM + ", RUN_MOVIE_ROOM_SEATS="
				+ RUN_MOVIE_ROOM_SEATS + "]";
	}
	public int getRUN_MOVIE_ROOM_SEATS() {
		return RUN_MOVIE_ROOM_SEATS;
	}
	public void setRUN_MOVIE_ROOM_SEATS(int rUN_MOVIE_ROOM_SEATS) {
		RUN_MOVIE_ROOM_SEATS = rUN_MOVIE_ROOM_SEATS;
	}
	public int getRUN_MOVIE_ID() {
		return RUN_MOVIE_ID;
	}
	public void setRUN_MOVIE_ID(int rUN_MOVIE_ID) {
		RUN_MOVIE_ID = rUN_MOVIE_ID;
	}
	public String getMOVIE_NM() {
		return MOVIE_NM;
	}
	public void setMOVIE_NM(String mOVIE_NM) {
		MOVIE_NM = mOVIE_NM;
	}
	public String getRUN_MOVIE_PRICE() {
		return RUN_MOVIE_PRICE;
	}
	public void setRUN_MOVIE_PRICE(String rUN_MOVIE_PRICE) {
		RUN_MOVIE_PRICE = rUN_MOVIE_PRICE;
	}
	public String getRUN_MOVIE_ST_TIME() {
		return RUN_MOVIE_ST_TIME;
	}
	public void setRUN_MOVIE_ST_TIME(String rUN_MOVIE_ST_TIME) {
		RUN_MOVIE_ST_TIME = rUN_MOVIE_ST_TIME;
	}
	public String getRUN_MOVIE_RUNTIME() {
		return RUN_MOVIE_RUNTIME;
	}
	public void setRUN_MOVIE_RUNTIME(String rUN_MOVIE_RUNTIME) {
		RUN_MOVIE_RUNTIME = rUN_MOVIE_RUNTIME;
	}
	public String getRUN_MOVIE_ROOM_NUM() {
		return RUN_MOVIE_ROOM_NUM;
	}
	public void setRUN_MOVIE_ROOM_NUM(String rUN_MOVIE_ROOM_NUM) {
		RUN_MOVIE_ROOM_NUM = rUN_MOVIE_ROOM_NUM;
	}
	
	
}
