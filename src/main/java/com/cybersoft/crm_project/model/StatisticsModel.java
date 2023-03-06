package com.cybersoft.crm_project.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cybersoft.crm_project.pojo.Task;

public class StatisticsModel {
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
				String tenDuAn=rs.getString("tenDuAn");
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
}
