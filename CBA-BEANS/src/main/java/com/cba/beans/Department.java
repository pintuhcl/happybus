/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cba.beans;

import java.io.Serializable;

/**
 * This class is used to hold Department Details From Common Wealth Bank
 * 
 * @author Mayur R Tibadiaya
 * @since CBABE 1.0
 */
public class Department implements Serializable {
	private Integer departmentId;
	private String departmentName;
	private String departmentDesc;
	private Integer headOfDepartment;///Employee fk

	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId
	 *            the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the departmentDesc
	 */
	public String getDepartmentDesc() {
		return departmentDesc;
	}

	/**
	 * @param departmentDesc
	 *            the departmentDesc to set
	 */
	public void setDepartmentDesc(String departmentDesc) {
		this.departmentDesc = departmentDesc;
	}

	/**
	 * @return the headOfDepartment
	 */
	public Integer getHeadOfDepartment() {
		return headOfDepartment;
	}

	/**
	 * @param headOfDepartment
	 *            the headOfDepartment to set
	 */
	public void setHeadOfDepartment(Integer headOfDepartment) {
		this.headOfDepartment = headOfDepartment;
	}

}
