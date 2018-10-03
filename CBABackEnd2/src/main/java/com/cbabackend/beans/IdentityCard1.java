package com.cbabackend.beans;

import java.util.Date;

/**
 * This class is used to hold  IdentityCard Information
 * 
 * @author Chandni
 * @since CBABE 1.0
 */

public class IdentityCard1 {
	private Integer idCardId;
	private String idCardNumber;
	private String idCardType;
	private String idCardHolderName;
	private Date issuedOn;
	private String issuedBy;
	private Date expDate;
	private Integer AddressId;
	/**
	 * @return the idCardId
	 */
	public Integer getIdCardId() {
		return idCardId;
	}
	/**
	 * @param idCardId the idCardId to set
	 */
	public void setIdCardId(Integer idCardId) {
		this.idCardId = idCardId;
	}
	/**
	 * @return the idCardNumber
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}
	/**
	 * @param idCardNumber the idCardNumber to set
	 */
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	/**
	 * @return the idCardType
	 */
	public String getIdCardType() {
		return idCardType;
	}
	/**
	 * @param idCardType the idCardType to set
	 */
	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}
	/**
	 * @return the idCardHolderName
	 */
	public String getIdCardHolderName() {
		return idCardHolderName;
	}
	/**
	 * @param idCardHolderName the idCardHolderName to set
	 */
	public void setIdCardHolderName(String idCardHolderName) {
		this.idCardHolderName = idCardHolderName;
	}
	/**
	 * @return the issuedOn
	 */
	public Date getIssuedOn() {
		return issuedOn;
	}
	/**
	 * @param issuedOn the issuedOn to set
	 */
	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}
	/**
	 * @return the issuedBy
	 */
	public String getIssuedBy() {
		return issuedBy;
	}
	/**
	 * @param issuedBy the issuedBy to set
	 */
	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}
	/**
	 * @return the expDate
	 */
	public Date getExpDate() {
		return expDate;
	}
	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return AddressId;
	}
	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		AddressId = addressId;
	}
}
	
	
	