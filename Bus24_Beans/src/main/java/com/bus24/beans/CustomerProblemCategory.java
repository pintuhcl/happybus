package com.bus24.beans;

import java.io.Serializable;

public class CustomerProblemCategory implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer customerProblemCategoryId;
	private String customerProblemCategoryName;
	public Integer getCustomerProblemCategoryId() {
		return customerProblemCategoryId;
	}
	public void setCustomerProblemCategoryId(Integer customerProblemCategoryId) {
		this.customerProblemCategoryId = customerProblemCategoryId;
	}
	public String getCustomerProblemCategoryName() {
		return customerProblemCategoryName;
	}
	public void setCustomerProblemCategoryName(String customerProblemCategoryName) {
		this.customerProblemCategoryName = customerProblemCategoryName;
	}
	

}
