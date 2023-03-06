package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.crm_project.model.MemberModel;
import com.cybersoft.crm_project.model.TaskModel;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.Task;
@WebServlet(urlPatterns = {"/member_list","/add_task_member","/task_delete_member","/view_task_member","/update_task_member",
		"/task_list_member","/add_task_view_member","/view_task_update_member"})
public class MemberController extends HttpServlet{
	
	MemberModel memberModel=new MemberModel();
	TaskModel taskModel = new TaskModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		NhanVien nhanVien = (NhanVien) session.getAttribute("member");
		String path = req.getServletPath();
		if(path.equals("/member_list")) {
//			Cookie[] cookie = req.getCookies();
//			String nhanVien = cookie[0].getValue();
			System.out.println(nhanVien);
			//Integer nhanVien1 =Integer.parseInt(nhan);
			List<Task> tasks= memberModel.viewAllMemberTaskById(nhanVien.getId_NV());
			req.setAttribute("list_task_member", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task.jsp").forward(req, resp);
		}
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String contextPath = req.getContextPath();
		
		if (path.equals("/task_list_member")) {
			List<Task> tasks= memberModel.viewAllMemberTaskById(nhanVien.getId_NV());
			req.setAttribute("list_task_member", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task.jsp").forward(req, resp);
		}
		if (path.equals("/add_task_view_member")) {
			List<Task> tasks= memberModel.viewAllMemberTaskById(nhanVien.getId_NV());
			req.setAttribute("list_task_member", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task-add.jsp").forward(req, resp);
		}
		if(path.equals("/task_delete")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			
			try {
				taskModel.deleteTask(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Task> tasks= memberModel.viewAllMemberTaskById(nhanVien.getId_NV());
			req.setAttribute("list_task_member", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task.jsp").forward(req, resp);
		}
		if (path.equals("/view_task_member")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task-view.jsp").forward(req, resp);
		}
		if (path.equals("/view_task_update_member")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_member/task-update.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if(path.equals("/add_task_member")) {
			String id_NV= req.getParameter("id_NV");
			Integer id_NV1 =Integer.parseInt(id_NV);
			String id_DuAn= req.getParameter("id_DuAn");
			Integer id_DuAn1 =Integer.parseInt(id_DuAn);
			String tenDuAn= req.getParameter("tenDuAn");
			String tentrangThai= req.getParameter("tentrangThai");
			String ngayBatDau= req.getParameter("ngayBatDau");
			String ngayKetThuc= req.getParameter("ngayKetThuc");
			Task task = new Task(id_NV1, id_DuAn1,tenDuAn, tentrangThai, ngayBatDau, ngayKetThuc);
			
			try {
				//Task task1 =taskModel.SearchNameById(id_NV1);
				//System.out.println(task1.getTenNhanVien());
				taskModel.insertTask(task);
				resp.sendRedirect(contextPath+"/add_task_view_member");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equals("/update_task_member")) {
			String id_task= req.getParameter("id_task");
			Integer id_task1 =Integer.parseInt(id_task);
			String id_NV= req.getParameter("id_NV");
			Integer id_NV1 =Integer.parseInt(id_NV);
			String id_DuAn= req.getParameter("id_DuAn");
			Integer id_DuAn1 =Integer.parseInt(id_DuAn);
			String tenDuAn= req.getParameter("tenDuAn");
			String tentrangThai= req.getParameter("tentrangThai");
			String ngayBatDau= req.getParameter("ngayBatDau");
			String ngayKetThuc= req.getParameter("ngayKetThuc");
			Task task = new Task(id_task1,id_NV1, id_DuAn1,tenDuAn, tentrangThai, ngayBatDau, ngayKetThuc);
			try {
				//Task task1 =taskModel.SearchNameById(id_NV1);
				//System.out.println(task1.getTenNhanVien());
				taskModel.updateTask(task);
				resp.sendRedirect(contextPath+"/task_list_member");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
