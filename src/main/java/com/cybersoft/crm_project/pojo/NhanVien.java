package com.cybersoft.crm_project.pojo;

public class NhanVien {

	private int id_NV;
	
	private String email;
	
	private String matKhau;
	
	private String hoTen;
	
	private String diaChi;
	
    private String sdt;
	
    private int id_role;
    
    
    public NhanVien() {}
	public NhanVien(int id_NV, String email, String matKhau, String hoTen, String diaChi, String sdt, int id_role) {
		super();
		this.id_NV = id_NV;
		this.email = email;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.id_role = id_role;
	}
	public NhanVien(String email, String matKhau, String hoTen, String diaChi, String sdt, int id_role) {
		super();
		this.email = email;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.id_role = id_role;
	}

	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public int getId_NV() {
		return id_NV;
	}
	public void setId_NV(int id_NV) {
		this.id_NV = id_NV;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

}
