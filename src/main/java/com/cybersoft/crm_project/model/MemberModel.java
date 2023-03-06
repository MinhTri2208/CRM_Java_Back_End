package com.cybersoft.crm_project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm_project.pojo.Task;

public class MemberModel {
	public List<Task> viewAllMemberTaskById(int id_NV) {
		List<Task> tasks =new ArrayList<Task>();
		Task task=null;
		String sqlString="select * from task where id_NV='"+id_NV+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_task");
				int id_NV1 = rs.getInt("id_NV");
				int id_DuAn =rs.getInt("id_DuAn");
				String tenDuAn=rs.getString("tenCongViec");
				String tentrangThai1 = rs.getString("tentrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				task =new Task(id, id_NV1, id_DuAn,tenDuAn, tentrangThai1, ngayBatDau, ngayKetThuc);
				tasks.add(task);
				System.out.println(sqlString);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
	}
	public List<Task> viewAllMemberTaskByIdd(int id_NV) {
		List<Task> tasks =new ArrayList<Task>();
		Task task=null;
		String sqlString="select * from task where id_NV= ? ";
		try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
	            preparedStatement.setInt(1, id_NV);
	            System.out.println(preparedStatement);
	            preparedStatement.executeQuery(sqlString);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return tasks;
	}
	public List<Task> viewAllTaskBy() {
		List<Task> tasks =new ArrayList<Task>();
		Task task=null;
		String sqlString="select * from task";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_task");
				int id_NV1 = rs.getInt("id_NV");
				int id_DuAn =rs.getInt("id_DuAn");
				String tenDuAn=rs.getString("tenDuAn");
				String tentrangThai1 = rs.getString("tentrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				task =new Task(id, id_NV1, id_DuAn,tenDuAn, tentrangThai1, ngayBatDau, ngayKetThuc);
				tasks.add(task);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return tasks;
	}
	
	public Task SearchNameById(int id_NV) {
		Task task=null;
		String sqlString="select * from nhanvien nv join task t on nv.id_NV=t.id_NV where nv.id_NV = ?;";
		try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
	            preparedStatement.setInt(1, id_NV);
	            System.out.println(preparedStatement);
	            preparedStatement.executeQuery(sqlString);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return task;
	}

	public Task SearchByID(int id_task) {
		Task task=null;
		String sqlString="select * from task where id_task='"+id_task+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_task");
				int id_NV1 = rs.getInt("id_NV");
				int id_DuAn =rs.getInt("id_DuAn");
				String tenDuAn=rs.getString("tenDuAn");
				String tentrangThai1 = rs.getString("tentrangThai");
				String ngayBatDau = rs.getString("ngayBatDau");
				String ngayKetThuc = rs.getString("ngayKetThuc");
				task =new Task(id_task, id_NV1, id_DuAn,tenDuAn, tentrangThai1, ngayBatDau, ngayKetThuc);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return task;
	}
	
    public void insertTask(Task task) throws SQLException {
        String sqlString="INSERT INTO task(id_task,id_NV,id_DuAn,tenDuAn,tentrangThai,ngayBatDau,ngayKetThuc) values(?,?,?,?,?,?,?);";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, task.getId_task());
            preparedStatement.setInt(2, task.getId_NV());
            preparedStatement.setInt(3, task.getId_DuAn());
            preparedStatement.setString(4, task.getTenDuAn());
            preparedStatement.setString(5, task.getTenTrangThai());
            preparedStatement.setString(6, task.getNgayBatDau());
            preparedStatement.setString(7, task.getNgayKetThuc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteTask(int id_task) throws SQLException {
        String sqlString="delete from task where id_task = ?;";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, id_task);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTask(Task task) throws SQLException {
        String sqlString="update task set id_task = ?,id_NV= ?, id_DuAn =?,tenDuAn=?,tentrangThai=?,ngayBatDau=?,ngayKetThuc=? where id_task = ?;";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, task.getId_task());
            preparedStatement.setInt(2, task.getId_NV());
            preparedStatement.setInt(3, task.getId_DuAn());
            preparedStatement.setString(4, task.getTenDuAn());
            preparedStatement.setString(5, task.getTenTrangThai());
            preparedStatement.setString(6, task.getNgayBatDau());
            preparedStatement.setString(7, task.getNgayKetThuc());
            preparedStatement.setInt(7, task.getId_task());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
