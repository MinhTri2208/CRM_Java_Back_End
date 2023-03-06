package com.cybersoft.crm_project.pojo;

public class Task {
	private int id_task ;
	private int id_NV ;
	private int id_DuAn ;
	private String tenDuAn;
	private String tenProject;
	private String tenNhanVien;
	private String tenTrangThai ;
	private String ngayBatDau;
	private String ngayKetThuc;
	
	public Task(int id_task, int id_NV, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_task = id_task;
		this.id_NV = id_NV;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public Task(int id_task, String ngayBatDau, String ngayKetThuc,String tenNhanVien,String tenProject,String tenDuAn) {
		super();
		this.tenDuAn=tenDuAn;
		this.id_task = id_task;
		this.tenNhanVien=tenNhanVien;
		this.tenProject = tenProject;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public Task(int id_task, String ngayBatDau, String ngayKetThuc,String tenNhanVien,String tenProject,String tenDuAn,String tenTrangThai) {
		super();
		this.tenDuAn=tenDuAn;
		this.id_task = id_task;
		this.tenNhanVien=tenNhanVien;
		this.tenProject = tenProject;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.tenTrangThai=tenTrangThai;
	}
	public Task(int id_task, int id_NV,String tenDuAn,String tenNhanVien, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_task = id_task;
		this.id_NV = id_NV;
		this.tenNhanVien=tenNhanVien;
		this.tenDuAn=tenDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	
	public Task(int id_task, int id_NV, int id_DuAn,String tenDuAn, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_task = id_task;
		this.id_NV = id_NV;
		this.id_DuAn = id_DuAn;
		this.tenDuAn=tenDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		
	}
	public Task(int id_NV, int id_DuAn,String tenDuAn, String tenTrangThai, String ngayBatDau, String ngayKetThuc) {
		super();
		this.id_NV = id_NV;
		this.id_DuAn = id_DuAn;
		this.tenDuAn=tenDuAn;
		this.tenTrangThai = tenTrangThai;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getId_DuAn() {
		return id_DuAn;
	}
	public void setId_DuAn(int id_DuAn) {
		this.id_DuAn = id_DuAn;
	}
	public int getId_task() {
		return id_task;
	}
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	public int getId_NV() {
		return id_NV;
	}
	public void setId_NV(int id_NV) {
		this.id_NV = id_NV;
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


	public String getTenDuAn() {
		return tenDuAn;
	}


	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getTenProject() {
		return tenProject;
	}
	public void setTenProject(String tenProject) {
		this.tenProject = tenProject;
	}

	
}
