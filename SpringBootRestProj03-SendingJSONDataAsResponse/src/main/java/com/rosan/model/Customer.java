package com.rosan.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {
	private Integer cno;
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", billAmt=" + billAmt + ", favColors="
				+ Arrays.toString(favColors) + ", studies=" + studies + ", phoneNumbers=" + phoneNumbers
				+ ", idDetails=" + idDetails + ", company=" + company + "]";
	}

	private String cname;
	private String[] favColors;
	private List<String> studies;
	private Set<Long> phoneNumbers;
	private Map<String, Object> idDetails;
	public Customer(Integer cno, String cname, Float billAmt, String[] favColors, List<String> studies,
			Set<Long> phoneNumbers, Map<String, Object> idDetails, Company company) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.billAmt = billAmt;
		this.favColors = favColors;
		this.studies = studies;
		this.phoneNumbers = phoneNumbers;
		this.idDetails = idDetails;
		this.company = company;
	}

	private Company company;

	public Customer() {

	}

	public Map<String, Object> getIdDetails() {
		return idDetails;
	}

	public void setIdDetails(Map<String, Object> idDetails) {
		this.idDetails = idDetails;
	}


	public String[] getFavColors() {
		return favColors;
	}

	public void setFavColors(String[] favColors) {
		this.favColors = favColors;
	}

	public List<String> getStudies() {
		return studies;
	}

	public void setStudies(List<String> studies) {
		this.studies = studies;
	}

	public Set<Long> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<Long> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	
	private Float billAmt;

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Float getBillAmt() {
		return billAmt;
	}

	public void setBillAmt(Float billAmt) {
		this.billAmt = billAmt;
	}

}
