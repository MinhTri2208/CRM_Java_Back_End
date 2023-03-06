package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.cybersoft.crm_project.model.DuAnModel;
import com.cybersoft.crm_project.model.RoleModel;
import com.cybersoft.crm_project.model.TaskModel;
import com.cybersoft.crm_project.model.UserModel;
import com.cybersoft.crm_project.pojo.DuAn;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.Task;
@WebServlet(urlPatterns = {"/leader","/add_user_leader","/view_leader","/update_leader","/user_list_leader","/xem_leader",
		"/view_update_leader","/delete_leader","/add_leader",
		"/add_duan_leader","/add_duan_view_leader","/delete_duan_leader","/update_duan_leader","/view_duan_leader","/duan_list_leader",
		"/view_update_duan_leader",
		"/add_task_leader","/task_delete_leader","/view_task_leader","/update_task_leader","/task_list_leader",
		"/add_task_view_leader","/view_task_update_leader"})
public class LeaderController extends HttpServlet{
	
	UserModel usersModel=new UserModel();
	DuAnModel duAnModel = new DuAnModel();
	TaskModel taskModel = new TaskModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		NhanVien nhanVien = (NhanVien) session.getAttribute("l");
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// get path
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		
		//admin
		
		if(path.equalsIgnoreCase("/leader")){
			req.getRequestDispatcher("./LayoutCrm_leader/index.jsp").forward(req, resp);
		}
		
		if(path.equalsIgnoreCase("/add_user_leader")){
			System.out.println("jfsfjsafj");
			req.getRequestDispatcher("./LayoutCrm_leader/user-add-admin.jsp").forward(req, resp);
		}
		
		if(path.equalsIgnoreCase("/user_list_leader")){
			List<NhanVien> nhanViens= usersModel.viewAllNhanVienLeader();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_leader/user-table.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/update_leader")){
			List<NhanVien> nhanViens= usersModel.viewAllNhanVien();
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_leader/user-update.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/view_update_leader")){
			//req.getParameter()
			String id = req.getParameter("id");
			NhanVien nhanViens= usersModel.SearchById(id);
			req.setAttribute("nhanvien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_leader/user-update.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/delete_leader")) {
			String id = req.getParameter("id");
			Integer id1= Integer.parseInt(id);
			try {
				usersModel.xoaNhanVien(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<NhanVien> nhanViens= usersModel.viewAllNhanVien();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_leader/user-table.jsp").forward(req, resp);
			//req.getRequestDispatcher("./LayoutCrm_leader/user-table.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/xem_leader")){
			//req.getParameter()
			String id = req.getParameter("id");
			NhanVien nhanViens= usersModel.SearchById(id);
			req.setAttribute("nhanvien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_leader/user-view.jsp").forward(req, resp);
		}

		//DuAn

		if (path.equals("/delete_duan_leader")) {
			
			String id_DuAn =req.getParameter("id_DuAn");
			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			DuAn duAn =new DuAn(id_DuAn1);
			try {
				duAnModel.deleteDuAn(duAn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(contextPath+"/duan_list_leader");
		}
		if (path.equals("/duan_list_leader")) {
			List<DuAn> duAns= duAnModel.viewAllDuAns();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listDuAns", duAns);
			req.getRequestDispatcher("./LayoutCrm_leader/groupwork.jsp").forward(req, resp);
		}
		if(path.equals("/add_duan_view_leader")) {
			req.getRequestDispatcher("./LayoutCrm_leader/groupwork-add.jsp").forward(req, resp);
		}
//		if (path.equals("/view_duan_leader")) {
//			
//			String id_DuAn =req.getParameter("id_DuAn");
//			Integer id_DuAn1= Integer.parseInt(id_DuAn);
//			DuAn duAn= duAnModel.searchById(id_DuAn);	
//			req.setAttribute("duAn", duAn);
//			req.getRequestDispatcher("./LayoutCrm_leader/groupwork-view.jsp").forward(req, resp);
//		}

	
		//TASK
		
		if (path.equals("/task_list_leader")) {
			List<Task> tasks= taskModel.viewAllTask();
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_leader/task.jsp").forward(req, resp);
		}
		if (path.equals("/add_task_view_leader")) {
			req.getRequestDispatcher("./LayoutCrm_leader/task-add.jsp").forward(req, resp);
		}
		if(path.equals("/task_delete_leader")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			
			try {
				taskModel.deleteTask(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Task> tasks= taskModel.viewAllTask();
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_leader/task.jsp").forward(req, resp);
		}

		if (path.equals("/view_task_leader")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_leader/task-view.jsp").forward(req, resp);
		}
		if (path.equals("/view_task_update_leader")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_leader/task-update.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		// admin
		//leader
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		System.out.println(path);
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(path.equalsIgnoreCase("/add_leader")) {
			String email = req.getParameter("email");
			String matKhau = req.getParameter("matKhau");
			String hoTen = req.getParameter("hoTen");
			String diaChi = req.getParameter("diaChi");
			String sdt = req.getParameter("sdt");
			String id_role = req.getParameter("id_role");
			int id_role1=Integer.parseInt(id_role);
//			String id_nv = req.getParameter("id_NV");
//			int id_NV=Integer.parseInt(id_nv);
			NhanVien nhanVien = new NhanVien(email, matKhau, hoTen, diaChi, sdt, id_role1);
			System.out.println("123456789");
			try {
				usersModel.insertUser(nhanVien);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("123");
			resp.sendRedirect(contextPath+"/add-user_leader");
		}
		if(path.equalsIgnoreCase("/update_leader")) {
			
			String id_NV = req.getParameter("id");
			int id_nv1=Integer.parseInt(id_NV);
			System.out.println(id_NV);
			String email = req.getParameter("email");
			String matKhau = req.getParameter("matKhau");
			String hoTen = req.getParameter("hoTen");
			String diaChi = req.getParameter("diaChi");
			String sdt = req.getParameter("sdt");
			String id_role = req.getParameter("role");
			int id_role1=Integer.parseInt(id_role);
					
			usersModel.updateNhanVien(id_nv1, email, matKhau, hoTen, diaChi, sdt, id_role1);
			resp.sendRedirect(contextPath+"/user_list");
		}
		//duan
		if (path.equals("/add_duan_leader")) {

			String tenDuAn =req.getParameter("tenDuAn");
			String tenTrangThai =req.getParameter("tenTrangThai");
			String ngayBatDau =req.getParameter("ngayBatDau");
			String ngayKetThuc =req.getParameter("ngayKetThuc");
			DuAn duAn =new DuAn(tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
			try {
				duAnModel.insertDuAn(duAn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(contextPath+"/duan_list_leader");
		}

		
		if (path.equals("/update_duan_leader")) {
			
//			String id_DuAn =req.getParameter("id_DuAn");
//			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			String tenDuAn =req.getParameter("tenDuAn");
			String tenTrangThai =req.getParameter("tenTrangThai");
			String ngayBatDau =req.getParameter("ngayBatDau");
			String ngayKetThuc =req.getParameter("ngayKetThuc");
			DuAn duAn =new DuAn(tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
			duAnModel.updateDuAn(duAn);
			resp.sendRedirect(contextPath+"/duan_list_leader");
		}
		
		if(path.equals("/add_task_leader")) {
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
				resp.sendRedirect(contextPath+"/add_task_view_leader");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equals("/update_task_leader")) {

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
				taskModel.updateTask(task);
				resp.sendRedirect(contextPath+"/task_list_leader");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
