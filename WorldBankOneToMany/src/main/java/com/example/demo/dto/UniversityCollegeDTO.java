package com.example.demo.dto;

import java.io.Serializable;

public class UniversityCollegeDTO implements Serializable {

	
	private int unid;
	private String uname;
	private String region;
	private int cid;
	private String cname;
	private String location;

	public UniversityCollegeDTO() {
		System.out.println("I AM IN University College DTO----------:::::");
	}

	public int getUnid() {
		return unid;
	}

	public void setUnid(int unid) {
		this.unid = unid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
