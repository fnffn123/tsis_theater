package com.tsis.beommi.dto;

// 사용자가 영화,좌석을고르고 이름,폰번호 넣어서 예매를 하면
// 이 data들을 받아와서 DB의 예매정보에 넣음(예매번호는 자동으로 넣어지게)
public class Movie_Reservation {
	private int movie_RESERVATION_ID;
	private int run_MOVIE_ID;
	private String owner_NM;
	private String phone_NUM;
	private String seat_NUM;
	public int getMovie_RESERVATION_ID() {
		return movie_RESERVATION_ID;
	}
	public void setMovie_RESERVATION_ID(int movie_RESERVATION_ID) {
		this.movie_RESERVATION_ID = movie_RESERVATION_ID;
	}
	public int getRun_MOVIE_ID() {
		return run_MOVIE_ID;
	}
	public void setRun_MOVIE_ID(int run_MOVIE_ID) {
		this.run_MOVIE_ID = run_MOVIE_ID;
	}
	public String getOwner_NM() {
		return owner_NM;
	}
	public void setOwner_NM(String owner_NM) {
		this.owner_NM = owner_NM;
	}
	public String getPhone_NUM() {
		return phone_NUM;
	}
	public void setPhone_NUM(String phone_NUM) {
		this.phone_NUM = phone_NUM;
	}
	public String getSeat_NUM() {
		return seat_NUM;
	}
	public void setSeat_NUM(String seat_NUM) {
		this.seat_NUM = seat_NUM;
	}
	@Override
	public String toString() {
		return "Movie_Reservation [movie_RESERVATION_ID=" + movie_RESERVATION_ID + ", run_MOVIE_ID=" + run_MOVIE_ID
				+ ", owner_NM=" + owner_NM + ", phone_NUM=" + phone_NUM + ", seat_NUM=" + seat_NUM + "]";
	}
 
	
	
	
}
