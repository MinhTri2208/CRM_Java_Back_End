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

public class DuAnModel {
	//search list
	 public List<DuAn> searchById(String id1) throws SQLException {
	        String sqlString="select * from duan where id_duan= "+id1+";";
	        // try-with-resource statement will auto close the connection.
	        DuAn duAn=null;
			List<DuAn> duAns =new ArrayList<DuAn>();
			try {
				Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sqlString);
				while (rs.next()) {
					int id = rs.getInt("id_DuAn");
					String tenDuAn = rs.getString("tenDuAn");
					String tenTrangThai1 = rs.getString("tenTrangThai");
					String ngayBatDau = rs.getString("ngayBatDau");
					String ngayKetThuc = rs.getString("ngayKetThuc");
					duAn =new DuAn(id, tenDuAn, tenTrangThai1, ngayBatDau, ngayKetThuc);
					duAns.add(duAn);
				}
				System.out.println(sqlString);
			}catch (SQLException e) {
					e.printStackTrace();
			}
			return duAns;
	 }
	 public List<DuAn> searchByName(String id1) throws SQLException {
	        String sqlString="select * from duan where tenDuAn= "+id1+";";
	        // try-with-resource statement will auto close the connection.
	        DuAn duAn=null;
			List<DuAn> duAns =new ArrayList<DuAn>();
			try {
				Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sqlString);
				while (rs.next()) {
					int id = rs.getInt("id_DuAn");
					String tenDuAn = rs.getString("tenDuAn");
					String tenTrangThai1 = rs.getString("tenTrangThai");
					String ngayBatDau = rs.getString("ngayBatDau");
					String ngayKetThuc = rs.getString("ngayKetThuc");
					duAn =new DuAn(id, tenDuAn, tenTrangThai1, ngayBatDau, ngayKetThuc);
					duAns.add(duAn);
				}
				System.out.println(sqlString);
			}catch (SQLException e) {
					e.printStackTrace();
			}
			return duAns;
	 }
	 public List<DuAn> searchByStatus(String id1) throws SQLException {
	        String sqlString="select * from duan where tenTrangThai "+id1+";";
	        // try-with-resource statement will auto close the connection.
	        DuAn duAn=null;
			List<DuAn> duAns =new ArrayList<DuAn>();
			try {
				Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sqlString);
				while (rs.next()) {
					int id = rs.getInt("id_DuAn");
					String tenDuAn = rs.getString("tenDuAn");
					String tenTrangThai1 = rs.getString("tenTrangThai");
					String ngayBatDau = rs.getString("ngayBatDau");
					String ngayKetThuc = rs.getString("ngayKetThuc");
					duAn =new DuAn(id, tenDuAn, tenTrangThai1, ngayBatDau, ngayKetThuc);
					duAns.add(duAn);
				}
				System.out.println(sqlString);
			}catch (SQLException e) {
					e.printStackTrace();
			}
			return duAns;
	 }
	//end
	public List<DuAn> viewAllDuAns() {
		List<DuAn> duAns =new ArrayList<DuAn>();
		DuAn duAn=null;
		String sqlString="select * from duan";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_DuAn");
				String tenDuAn = rs.getString("tenDuAn");
				String tenTrangThai = rs.getString("tenTrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				
				duAn =new DuAn(id, tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
				duAns.add(duAn);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return duAns;
	}

    public void insertDuAn(DuAn duAn) throws SQLException {
        String sqlString="INSERT INTO duan(id_DuAn,tenDuAn,tenTrangThai,ngayBatDau,ngayKetThuc) values(?,?,?,?,?);";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, duAn.getId_DuAn());
            preparedStatement.setString(2, duAn.getTenDuAn());
            preparedStatement.setString(3, duAn.getTenTrangThai());
            preparedStatement.setString(4, duAn.getNgayBatDau());
            preparedStatement.setString(5, duAn.getNgayKetThuc());            
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteDuAn(DuAn duAn) throws SQLException {
        String sqlString="delete from duan where id_DuAn = ?;";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, duAn.getId_DuAn());         
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public boolean updateDuAn(DuAn duAn) {
		String sqlString="update duan set id_DuAn = ?, tenDuAn= ?, tenTrangThai =?,ngayBatDau =?,ngayKetThuc=? where id_DuAn = ?;" ;
		boolean rowUpdated=false;
		 try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
			 	preparedStatement.setInt(1, duAn.getId_DuAn());
	            preparedStatement.setString(2, duAn.getTenDuAn());
	            preparedStatement.setString(3, duAn.getTenTrangThai());
	            preparedStatement.setString(4, duAn.getNgayBatDau());
	            preparedStatement.setString(5, duAn.getNgayKetThuc());
			 	preparedStatement.setInt(6, duAn.getId_DuAn());
	            System.out.println(preparedStatement);
	            rowUpdated = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return rowUpdated;
	}
	public boolean viewDuAn(DuAn duAn) {
		String sqlString="select * from duan where id_DuAn = ?;" ;
		boolean rowUpdated=false;
		 try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
			 	preparedStatement.setInt(1, duAn.getId_DuAn());
//	            preparedStatement.setString(1, duAn.getTenDuAn());
//	            preparedStatement.setString(2, duAn.getTenTrangThai());
//	            preparedStatement.setString(3, duAn.getNgayBatDau());
//	            preparedStatement.setString(4, duAn.getNgayKetThuc());
//			 	preparedStatement.setInt(5, duAn.getId_DuAn());
	            System.out.println(preparedStatement);
	            rowUpdated = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return rowUpdated;
	}
	public String tenDAByID(String id) {
		String sqlString="select distinct da.tenDuAn\r\n"
				+ "	from task t \r\n"
				+ "	join duan da on da.id_DuAn=t.id_DuAn \r\n"
				+ "    where da.id_DuAn='"+id+"' ;";
		String name ="";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				name =name+ rs.getString("tenDuAn");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return name;
	}
// Search List	
	public DuAn SearchAllDuAnByID(int id_DuAn) {
		DuAn duAn=null;
		List<DuAn> duAns=new ArrayList<DuAn>();
		String sqlString="select * from duan where id_DuAn ='"+id_DuAn+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_DuAn");
				String tenDuAn = rs.getString("tenDuAn");
				String tenTrangThai = rs.getString("tenTrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				duAn =new DuAn(id, tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
				duAns.add(duAn);
			}
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return duAn;
	}

	public List<DuAn> searchDAByStatus(String tenTrangThai) {
		String sqlString="select * from duan where id_DuAn ='"+tenTrangThai+"'";
		DuAn duAn=null;
		List<DuAn> duAns =new ArrayList<DuAn>();
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_DuAn");
				String tenDuAn = rs.getString("tenDuAn");
				String tenTrangThai1 = rs.getString("tenTrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				duAn =new DuAn(id, tenDuAn, tenTrangThai1, ngayBatDau, ngayKetThuc);
				duAns.add(duAn);
			}
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return duAns;
	}
	public List<DuAn> searchDAByName(String tenTrangThai) {
		String sqlString="select * from duan where id_DuAn ='"+tenTrangThai+"'";
		DuAn duAn=null;
		List<DuAn> duAns =new ArrayList<DuAn>();
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_DuAn");
				String tenDuAn = rs.getString("tenDuAn");
				String tenTrangThai1 = rs.getString("tenTrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				duAn =new DuAn(id, tenDuAn, tenTrangThai1, ngayBatDau, ngayKetThuc);
				duAns.add(duAn);
			}
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return duAns;
	}
// end
	public List<Task> detail_duanDHT(String id_DuAn) {
		String sqlString="call detail_duanDHT('"+id_DuAn+"');";
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
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
	}
	public List<Task> detail_duanDTH(String id_DuAn) {
		String sqlString="call detail_duanDTH('"+id_DuAn+"');";
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
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
	}
	public List<Task> detail_duanCHT(String id_DuAn) {
		String sqlString="call detail_duanCHT('"+id_DuAn+"');";
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
			System.out.println(sqlString);
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
	}
	public int count_duanCHT(String id_DuAn) {
		String sqlString="select count(*) allTask\r\n"
				+ "	from task t \r\n"
				+ "	join duan da on t.id_DuAn=da.id_DuAn \r\n"
				+ "    where da.id_duan="+id_DuAn+" and t.tentrangThai like '%chưa hoành thành%';";
		int count=0;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				count =count+ rs.getInt("allTask");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}
	public int count_duanDTH(String id_DuAn) {
		String sqlString="select count(*) allTask\r\n"
				+ "	from task t \r\n"
				+ "	join duan da on t.id_DuAn=da.id_DuAn \r\n"
				+ "    where da.id_duan="+id_DuAn+" and t.tentrangThai like '%Đang thực hiện%';";
		int count=0;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				count =count+ rs.getInt("allTask");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}
	public int count_duanDHT(String id_DuAn) {
		String sqlString="select count(*) allTask\r\n"
				+ "	from task t \r\n"
				+ "	join duan da on t.id_DuAn=da.id_DuAn \r\n"
				+ "    where da.id_duan="+id_DuAn+" and t.tentrangThai like '%Đã hoành thành%';";
		int count=0;
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				count =count+ rs.getInt("allTask");
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return count;
	}
}
