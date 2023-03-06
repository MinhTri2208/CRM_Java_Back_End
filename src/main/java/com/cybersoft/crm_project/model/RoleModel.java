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

public class RoleModel {
	
	public List<Roles> viewAllRoles() {
		List<Roles> rolesList =new ArrayList<Roles>();
		Roles roles=null;
		String sqlString="select * from role";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_role");
				String id_name = rs.getString("id_name");
				String mota = rs.getString("mota");				
				roles=new Roles(id, id_name, mota);
				System.out.println(sqlString);
				rolesList.add(roles);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return rolesList;
	}
	//Search List
	public List<Roles> searchID(String id_roles) throws SQLException {
		String sqlString="select * from role where id_role = "+id_roles+";";
		List<Roles> rolesList =new ArrayList<Roles>();
		Roles roles=null;		
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_role");
				String id_name = rs.getString("id_name");
				String mota = rs.getString("mota");				
				roles=new Roles(id, id_name, mota);
				System.out.println(sqlString);
				rolesList.add(roles);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return rolesList;
	}
	public List<Roles> searchName(String id_roles) throws SQLException {
		String sqlString="select * from role where id_name = '"+id_roles+"';";
		List<Roles> rolesList =new ArrayList<Roles>();
		Roles roles=null;		
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_role");
				String id_name = rs.getString("id_name");
				String mota = rs.getString("mota");				
				roles=new Roles(id, id_name, mota);
				System.out.println(sqlString);
				rolesList.add(roles);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return rolesList;
	}
	//end
    public void insertRole(Roles roles) throws SQLException {
        String sqlString="INSERT INTO role(id_role,id_name,mota) values(?,?,?);";
        // try-with-resource statement will auto close the connection.
        try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
            preparedStatement.setInt(1, roles.getId_role());
            preparedStatement.setString(2, roles.getId_name());
            preparedStatement.setString(3, roles.getMota());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	public boolean deleteRoles(int id_roles) throws SQLException {
		String sqlString="delete from role where id_role = ?;";
		boolean rowDeleted = false;
		try {
				Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlString); {
		            statement.setInt(1, id_roles);
		            rowDeleted = statement.executeUpdate() > 0;
				}
			}catch (SQLException e) {
				e.printStackTrace();
		}
		return rowDeleted;
	}
	public boolean updateRoles(Roles roles) {
		String sqlString="update role set id_role = ?,id_name= ?, mota =? where id_role = ?;" ;
		boolean rowUpdated=false;
		 try (Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection(); 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sqlString)) {
	            preparedStatement.setInt(1, roles.getId_role());
	            preparedStatement.setString(2, roles.getId_name());
	            preparedStatement.setString(3, roles.getMota());
	            preparedStatement.setInt(4, roles.getId_role());
	            System.out.println(preparedStatement);
	            rowUpdated = preparedStatement.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		 return rowUpdated;
	}
	public boolean viewRoles(int id_roles) throws SQLException {
		String sqlString="select * from role where id_role = ?;";
		boolean rowDeleted = false;
		try {
				Connection connection = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlString); {
		            statement.setInt(1, id_roles);
		            rowDeleted = statement.executeUpdate() > 0;
				}
			}catch (SQLException e) {
				e.printStackTrace();
		}
		return rowDeleted;
	}
	public Roles SearchByID(int id_role) {
		Roles roles=null;
		String sqlString="select * from role where id_role='"+id_role+"'";
		try {
			Connection con = com.cybersoft.crm_project.connection.MySQLConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlString);
			while (rs.next()) {
				int id = rs.getInt("id_role");
				String tenDuAn=rs.getString("id_name");
				String tentrangThai1 = rs.getString("mota");
				roles = new Roles(id, tenDuAn, tentrangThai1);
				System.out.println(sqlString);
			}
		}catch (SQLException e) {
				e.printStackTrace();
		}
		return roles;
	}
	
}
