package com.companyname.demo;

public class Employess {
	private long id;
	private String name;
	private String sdt;
	private String diaChi;
	public Employess() {
		super();
	}
	public Employess(long id, String name, String sdt, String diaChi) {
		super();
		this.id = id;
		this.name = name;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public String toString() {
		return "Employess [id=" + id + ", name=" + name + ", sdt=" + sdt + ", diaChi=" + diaChi + "]";
	};
	
	
	
	

}
