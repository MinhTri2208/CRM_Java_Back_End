package com.cybersoft.crm_project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm_project.pojo.DuAn;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.Roles;
import com.cybersoft.crm_project.pojo.Task;
import com.cybersoft.crm_project.pojo.User;

public class UserModel {
// SEARCH LIST
	
	public NhanVien Search(String email,String password) {
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien where email='"+email+"' and matKhau='"+password+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanVien;
	}
	public List<NhanVien> SearchByID(String id_NV) {
		List<NhanVien> nhanViens =new ArrayList<NhanVien>();
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien where id_NV='"+id_NV+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
				nhanViens.add(nhanVien);
				System.out.println(sqlString);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}
	public NhanVien SearchById(String id_Nv) {
		List<NhanVien> nhanViens =new ArrayList<NhanVien>();
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien where id_NV='"+id_Nv+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
				nhanViens.add(nhanVien);
				System.out.println(sqlString);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanVien;
	}
	public List<NhanVien> SearchByName(String name) {
		NhanVien nhanVien=null;
		List<NhanVien> nhanViens=new ArrayList<NhanVien>();
		String sqlString="select * from nhanvien where hoTen='"+name+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");
				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
				nhanViens.add(nhanVien);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}
	public List<NhanVien> SearchByEmail(String email) {
		NhanVien nhanVien=null;
		List<NhanVien> nhanViens=new ArrayList<NhanVien>();
		String sqlString="select * from nhanvien where email='"+email+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
				nhanViens.add(nhanVien);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}
	public List<NhanVien> SearchByPhone(String phone){
		NhanVien nhanVien=null;
		List<NhanVien> nhanViens=new ArrayList<NhanVien>();
		String sqlString="select * from nhanvien where sdt='"+phone+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen = rs.getString("hoTen");
				String diaChi = rs.getString("diaChi");
				String sdt = rs.getString("sdt");
				int id_role = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen, diaChi, sdt, id_role);
				nhanViens.add(nhanVien);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}
//	END
	public NhanVien viewNhanVien(String email, String matKhau, String hoTen, String diaChi, String sdt, int id_role) {
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien where email='"+email+"' and matKhau='"+matKhau+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen1 = rs.getString("hoTen");
				String diaChi1 = rs.getString("diaChi");
				String sdt1 = rs.getString("sdt");
				int id_role1 = rs.getInt("id_role");

				nhanVien =new NhanVien(id, email1,matkhau1, hoTen1, diaChi1, sdt1, id_role1);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanVien;
	}
	public List<NhanVien> viewAllNhanVien() {
		List<NhanVien> nhanViens =new ArrayList<NhanVien>();
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen1 = rs.getString("hoTen");
				String diaChi1 = rs.getString("diaChi");
				String sdt1 = rs.getString("sdt");
				int id_role1 = rs.getInt("id_role");
				
				nhanVien =new NhanVien(id, email1,matkhau1, hoTen1, diaChi1, sdt1, id_role1);
				nhanViens.add(nhanVien);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}
	public List<NhanVien> viewAllNhanVienLeader() {
		List<NhanVien> nhanViens =new ArrayList<NhanVien>();
		NhanVien nhanVien=null;
		String sqlString="select * from nhanvien where id_role=0";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matkhau1 = rs.getString("matKhau");
				String hoTen1 = rs.getString("hoTen");
				String diaChi1 = rs.getString("diaChi");
				String sdt1 = rs.getString("sdt");
				int id_role1 = rs.getInt("id_role");
				
				nhanVien =new NhanVien(id, email1,matkhau1, hoTen1, diaChi1, sdt1, id_role1);
				nhanViens.add(nhanVien);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanViens;
	}

    public void insertUser(NhanVien nhanVien) throws SQLException {
        System.out.println();
        String sqlString="INSERT INTO nhanvien(id_NV,email,matKhau,hoTen,diaChi,sdt,id_role) values(?,?,?,?,?,?,?);";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, nhanVien.getId_NV());
            preparedStatement.setString(2, nhanVien.getEmail());
            preparedStatement.setString(3, nhanVien.getMatKhau());
            preparedStatement.setString(4, nhanVien.getHoTen());
            preparedStatement.setString(5, nhanVien.getDiaChi());
            preparedStatement.setString(6, nhanVien.getSdt());
            preparedStatement.setInt(7, nhanVien.getId_role());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public boolean xoaNhanVien(int id_NV) throws SQLException {
		NhanVien nhanVien=null;
		String sqlString="delete from nhanvien where id_NV = ?;";
		boolean rowDeleted = false;
		try {
				Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlString); {
		            statement.setInt(1, id_NV);
		            rowDeleted = statement.executeUpdate() > 0;
				}
			}catch (SQLException e) {
				e.printStackTrace();
		}
		return rowDeleted;
	}
	public NhanVien updateNhanVien(int id_NV,String email,String matKhau, String hoTen, String diaChi, String sdt, int id_role) {
		NhanVien nhanVien=null;
		String sqlString="update nhanvien set "
				+ "email = '"+email
				+"' and matKhau='"+matKhau
				+"' and hoTen='"+hoTen
				+"' and diaChi='"+diaChi
				+"' and sdt='"+sdt
				+"' and id_role ='"+id_role
				+"' where id_NV='"+id_NV+"'" ;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id_NV1 = rs.getInt("id_NV");
				String email1 = rs.getString("email");
				String matKhau1 = rs.getString("matKhau");
				String hoTen1=rs.getString("hoTen");
				String diaChi1=rs.getString("diaChi");
				String sdt1=rs.getString("sdt");
				int id_role1=rs.getInt("id_role");
				nhanVien=new NhanVien(id_NV1, email1, matKhau1, hoTen1, diaChi1, sdt1, id_role1);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return nhanVien;
	}
	public boolean updateNhanVien1(int id_NV,String email,String matKhau, String hoTen, String diaChi, String sdt, int id_role) {
		NhanVien nhanVien=null;
		String sqlString="update nhanvien set "
				+ "email = '"+email
				+"' , matKhau='"+matKhau
				+"' , hoTen='"+hoTen
				+"' , diaChi='"+diaChi
				+"' , sdt='"+sdt
				+"' , id_role ='"+id_role
				+"' where id_NV='"+id_NV+"'" ;
		boolean rowDeleted = false;
		try {
				Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlString); {
		            rowDeleted = statement.executeUpdate() > 0;
				}
				System.out.println(statement);
			}catch (SQLException e) {
				e.printStackTrace();
		}
		return rowDeleted;
	}
	public List<Task> statusTaskUser(String id_NV,String status) {
		String sqlString="call status_task('"+id_NV+"','"+status+"');";
		//String status1="%"+status+"%";
		List<Task> tasks =new ArrayList<Task>();
		Task task=null;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_task");
				String tenDuAn = rs.getString("tenDuAn");
				String tenNhanVien=rs.getString("hoTen");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				String tenProject= rs.getString("tenCongViec");
				task =new Task(id,ngayBatDau,ngayKetThuc,tenNhanVien,tenProject,tenDuAn);
				tasks.add(task);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
    }
	public int countStatus(String id,String status) {
		String sqlString="call count_duan('"+id+"','"+status+"');";
		int count=0;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				count = rs.getInt("allTask");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}
	public String tenNV(String id) {
		String sqlString="select distinct nv.hoten\r\n"
				+ "	from task t \r\n"
				+ "	join nhanvien nv on nv.id_NV=t.id_NV \r\n"
				+ "    where nv.id_nv='"+id+"' ;";
		String name ="";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				name =name+ rs.getString("hoten");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return name;
	}
	public String emailNV(String id) {
		String sqlString="select distinct nv.email\r\n"
				+ "	from task t \r\n"
				+ "	join nhanvien nv on nv.id_NV=t.id_NV \r\n"
				+ "    where nv.id_nv='"+id+"' ;";
		String email ="";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				email =email+ rs.getString("email");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return email;
	}
	
}
