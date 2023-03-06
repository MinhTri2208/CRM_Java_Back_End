package com.cybersoft.crm_project.pojo;

public class DuAn {
	private int id_DuAn;
	private String tenDuAn;
	private String tenTrangThai;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	public DuAn(int id_DuAn, String tenDuAn, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_DuAn = id_DuAn;
		this.tenDuAn = tenDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public DuAn(String tenDuAn, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.tenDuAn = tenDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public DuAn(int id_DuAn) {
		super();
		this.id_DuAn = id_DuAn;
	}
	public int getId_DuAn() {
		return id_DuAn;
	}
	public void setId_DuAn(int id_DuAn) {
		this.id_DuAn = id_DuAn;
	}
	public String getTenDuAn() {
		return tenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	public String getTenTrangThai() {
		return tenTrangThai;
	}
	public void setTenTrangThai(String tenTrangThai) {
		this.tenTrangThai = tenTrangThai;
	}
	public String getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(String ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public String getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(String ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}


	
}
