package com.rosan.model;

public class Customer {
	private Integer cno;
	private String cname;
	private String cadd;
	private Float billamt;

	public Customer(Integer cno, String cname, String cadd, Float billamt) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.cadd = cadd;
		this.billamt = billamt;
	}

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

	public String getCadd() {
		return cadd;
	}

	public void setCadd(String cadd) {
		this.cadd = cadd;
	}

	public Float getBillamt() {
		return billamt;
	}

	public void setBillamt(Float billamt) {
		this.billamt = billamt;
	}
}
