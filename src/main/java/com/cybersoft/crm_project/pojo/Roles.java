package com.cybersoft.crm_project.pojo;


public class Roles {

	private int id_role ;
	
	private String id_name;
	
	private String mota;
	public Roles() {};
	public Roles(int id_role, String id_name, String mota) {
		super();
		this.id_role = id_role;
		this.id_name = id_name;
		this.mota = mota;
	}
	public Roles(String id_name, String mota) {
		super();
		this.id_name = id_name;
		this.mota = mota;
	}
	public Roles(int id_role1) {
		super();
		this.id_role = id_role;
	}
	public void setId_name(String id_name) {
		this.id_name = id_name;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public String getId_name() {
		return id_name;
	}
	public void setRole_name(String id_name) {
		this.id_name = id_name;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
}
