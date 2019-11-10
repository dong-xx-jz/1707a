package com.bw.entity;

public class Movie {
	
	private Integer mid;
	
	private String mname;
	
	private String introduction;
	
	private Double price;
	
	private String startDate;
	
	private Integer tid;
	private String tname;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer mid, String mname, String introduction, Double price, String startDate) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.introduction = introduction;
		this.price = price;
		this.startDate = startDate;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", introduction=" + introduction + ", price=" + price
				+ ", startDate=" + startDate + "]";
	}
	
	

}
