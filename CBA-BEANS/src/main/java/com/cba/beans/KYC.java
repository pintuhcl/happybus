/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;

import java.io.Serializable;

/**
 * This class is used to hold KYC Document Details
 * 
 * @author Mayur R Tibadiya
 * @since CBABE 1.0
 */
public class KYC implements Serializable {

	private Integer kycId;
	private String ausPassport;
	private String ausDriverLicense;
	private String ausAgeCard;
	private String ausDFICard;
	private String ausFirearmsLicense;
	private String foreignNationalIdCard;
	private String foreignPassport;
	private String ausBirthCertificate;
	private String ausCitizenshipCertificate;
	private String ausPensionCard;
	private String foreignBrithCertificate;
	private String foreignCitizenshipCertificate;
	private String ausTFN;
	private String ausABN;

	/**
	 * @return the kycId
	 */
	public Integer getKycId() {
		return kycId;
	}

	/**
	 * @param kycId
	 *            the kycId to set
	 */
	public void setKycId(Integer kycId) {
		this.kycId = kycId;
	}

	/**
	 * @return the ausPassport
	 */
	public String getAusPassport() {
		return ausPassport;
	}

	/**
	 * @param ausPassport
	 *            the ausPassport to set
	 */
	public void setAusPassport(String ausPassport) {
		this.ausPassport = ausPassport;
	}

	/**
	 * @return the ausDriverLicense
	 */
	public String getAusDriverLicense() {
		return ausDriverLicense;
	}

	/**
	 * @param ausDriverLicense
	 *            the ausDriverLicense to set
	 */
	public void setAusDriverLicense(String ausDriverLicense) {
		this.ausDriverLicense = ausDriverLicense;
	}

	/**
	 * @return the ausAgeCard
	 */
	public String getAusAgeCard() {
		return ausAgeCard;
	}

	/**
	 * @param ausAgeCard
	 *            the ausAgeCard to set
	 */
	public void setAusAgeCard(String ausAgeCard) {
		this.ausAgeCard = ausAgeCard;
	}

	/**
	 * @return the ausDFICard
	 */
	public String getAusDFICard() {
		return ausDFICard;
	}

	/**
	 * @param ausDFICard
	 *            the ausDFICard to set
	 */
	public void setAusDFICard(String ausDFICard) {
		this.ausDFICard = ausDFICard;
	}

	/**
	 * @return the ausFirearmsLicense
	 */
	public String getAusFirearmsLicense() {
		return ausFirearmsLicense;
	}

	/**
	 * @param ausFirearmsLicense
	 *            the ausFirearmsLicense to set
	 */
	public void setAusFirearmsLicense(String ausFirearmsLicense) {
		this.ausFirearmsLicense = ausFirearmsLicense;
	}

	/**
	 * @return the foreignNationalIdCard
	 */
	public String getForeignNationalIdCard() {
		return foreignNationalIdCard;
	}

	/**
	 * @param foreignNationalIdCard
	 *            the foreignNationalIdCard to set
	 */
	public void setForeignNationalIdCard(String foreignNationalIdCard) {
		this.foreignNationalIdCard = foreignNationalIdCard;
	}

	/**
	 * @return the foreignPassport
	 */
	public String getForeignPassport() {
		return foreignPassport;
	}

	/**
	 * @param foreignPassport
	 *            the foreignPassport to set
	 */
	public void setForeignPassport(String foreignPassport) {
		this.foreignPassport = foreignPassport;
	}

	/**
	 * @return the ausBirthCertificate
	 */
	public String getAusBirthCertificate() {
		return ausBirthCertificate;
	}

	/**
	 * @param ausBirthCertificate
	 *            the ausBirthCertificate to set
	 */
	public void setAusBirthCertificate(String ausBirthCertificate) {
		this.ausBirthCertificate = ausBirthCertificate;
	}

	/**
	 * @return the ausCitizenshipCertificate
	 */
	public String getAusCitizenshipCertificate() {
		return ausCitizenshipCertificate;
	}

	/**
	 * @param ausCitizenshipCertificate
	 *            the ausCitizenshipCertificate to set
	 */
	public void setAusCitizenshipCertificate(String ausCitizenshipCertificate) {
		this.ausCitizenshipCertificate = ausCitizenshipCertificate;
	}

	/**
	 * @return the ausPensionCard
	 */
	public String getAusPensionCard() {
		return ausPensionCard;
	}

	/**
	 * @param ausPensionCard
	 *            the ausPensionCard to set
	 */
	public void setAusPensionCard(String ausPensionCard) {
		this.ausPensionCard = ausPensionCard;
	}

	/**
	 * @return the foreignBrithCertificate
	 */
	public String getForeignBrithCertificate() {
		return foreignBrithCertificate;
	}

	/**
	 * @param foreignBrithCertificate
	 *            the foreignBrithCertificate to set
	 */
	public void setForeignBrithCertificate(String foreignBrithCertificate) {
		this.foreignBrithCertificate = foreignBrithCertificate;
	}

	/**
	 * @return the foreignCitizenshipCertificate
	 */
	public String getForeignCitizenshipCertificate() {
		return foreignCitizenshipCertificate;
	}

	/**
	 * @param foreignCitizenshipCertificate
	 *            the foreignCitizenshipCertificate to set
	 */
	public void setForeignCitizenshipCertificate(String foreignCitizenshipCertificate) {
		this.foreignCitizenshipCertificate = foreignCitizenshipCertificate;
	}

	/**
	 * @return the ausTFN
	 */
	public String getAusTFN() {
		return ausTFN;
	}

	/**
	 * @param ausTFN
	 *            the ausTFN to set
	 */
	public void setAusTFN(String ausTFN) {
		this.ausTFN = ausTFN;
	}

	/**
	 * @return the ausABN
	 */
	public String getAusABN() {
		return ausABN;
	}

	/**
	 * @param ausABN
	 *            the ausABN to set
	 */
	public void setAusABN(String ausABN) {
		this.ausABN = ausABN;
	}

}
