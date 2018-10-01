package com.bus24.beans;

/**
 * 
 * @author mulayam
 *
 */
public class Passenger {

	private Integer passengerId;
	private String name;
	private String gender;
	private Integer age;
	private Integer bookingId;
	private String seatNo;
	private Integer status;

	/**
	 * @return the passengerId
	 */
	public Integer getPassengerId() {
		return passengerId;
	}

	/**
	 * @param passengerId
	 *            the passengerId to set
	 */
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the bookingId
	 */
	public Integer getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 *            the bookingId to set
	 */
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the seatNo
	 */
	public String getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo
	 *            the seatNo to set
	 */
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", bookingId=" + bookingId + ", seatNo=" + seatNo + ", status=" + status + "]";
	}

}
