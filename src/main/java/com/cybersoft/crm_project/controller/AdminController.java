package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.crm_project.model.RoleModel;
import com.cybersoft.crm_project.model.UserModel;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.Task;

@WebServlet(urlPatterns ={"/admin","/add-user","/view","/update","/user_list","/xem",
							"/view_update","/delete","/add","/task_status_user","/search_by_id","/search_by_name","/search_by_phone","/search_by_email"})
public class AdminController extends HttpServlet{
	
	UserModel usersModel=new UserModel();
	RoleModel roleModel=new RoleModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// get path
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
				
		if(path.equalsIgnoreCase("/admin")){
			req.getRequestDispatcher("./LayoutCrm_admin/index.jsp").forward(req, resp);
		}
		
		if(path.equalsIgnoreCase("/add-user")){
			System.out.println("jfsfjsafj");
			req.getRequestDispatcher("./LayoutCrm_admin/user-add-admin.jsp").forward(req, resp);
		}
		
		if(path.equalsIgnoreCase("/user_list")){
			List<NhanVien> nhanViens= usersModel.viewAllNhanVien();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/update")){
			List<NhanVien> nhanViens= usersModel.viewAllNhanVien();
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-update.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/view_update")){
			String id = req.getParameter("id");
			NhanVien nhanViens= usersModel.SearchById(id);
			req.setAttribute("nhanvien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-update.jsp").forward(req, resp);
		}
		//search List
		if(path.equalsIgnoreCase("/search_by_id")){
			String id = req.getParameter("id_NV");
			List<NhanVien> nhanViens= usersModel.SearchByID(id);

			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table2.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/search_by_name")){
			String name = req.getParameter("hoTen");
			List<NhanVien> nhanViens= usersModel.SearchByName(name);
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table2.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/SearchByPhone")){
			String id = req.getParameter("phone");
			List<NhanVien> nhanViens= usersModel.SearchByPhone(id);

			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table2.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/search_by_phone")){
			String id = req.getParameter("phone");
			List<NhanVien> nhanViens= usersModel.SearchByPhone(id);

			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table2.jsp").forward(req, resp);
		}
		if(path.equalsIgnoreCase("/search_by_email")){
			String id = req.getParameter("email");
			List<NhanVien> nhanViens= usersModel.SearchByEmail(id);

			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table2.jsp").forward(req, resp);
		}
		//end
		
		if(path.equalsIgnoreCase("/delete")) {
			String id = req.getParameter("id");
			Integer id1= Integer.parseInt(id);
			try {
				usersModel.xoaNhanVien(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<NhanVien> nhanViens= usersModel.viewAllNhanVien();
			req.setAttribute("listNhanVien", nhanViens);
			req.getRequestDispatcher("./LayoutCrm_admin/user-table.jsp").forward(req, resp);
		}

		if(path.equalsIgnoreCase("/task_status_user")){
			//req.getParameter()
			String id = req.getParameter("id");
			//Integer id1= Integer.parseInt(id);
			//String tenTrangThai = req.getParameter("tenTrangThai");
			System.out.println(id);
			List<Task> tasks= usersModel.statusTaskUser(id, "chua hoanh thanh");
			List<Task> tasks1= usersModel.statusTaskUser(id, "da hoanh thanh");
			List<Task> tasks2= usersModel.statusTaskUser(id, "dang thuc hien");
			double countDHT= usersModel.countStatus(id, "Đã hoành thành");
			double countCHT= usersModel.countStatus(id, "chưa hoành thành");
			double countDTH= usersModel.countStatus(id, "Đang thực hiện");
			double countAll=countCHT+countDHT+countDTH;
			System.out.println(countAll);
			String name = usersModel.tenNV(id);
			req.setAttribute("name", name);
			String email = usersModel.emailNV(id);
			req.setAttribute("email", email);
//			double percentDHT= (countDHT/countAll)*100;
//			double percentCHT= (countCHT/countAll)*100;
//			double percentDTH= (countDTH/countAll)*100;
			req.setAttribute("task", tasks);
			req.setAttribute("task1", tasks1);
			req.setAttribute("task2", tasks2);
			req.setAttribute("countDHT", countDTH);
			req.setAttribute("countCHT", countCHT);
			req.setAttribute("countDTH", countDHT);
			req.getRequestDispatcher("./LayoutCrm_admin/user-details.jsp").forward(req, resp);
		}
//	SEARCH LIST
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get path
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		System.out.println(path);
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		if(path.equalsIgnoreCase("/add")) {
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
			resp.sendRedirect(contextPath+"/add-user");
		}
		if(path.equalsIgnoreCase("/update")) {
			
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
					
			usersModel.updateNhanVien1(id_nv1, email, matKhau, hoTen, diaChi, sdt, id_role1);
			resp.sendRedirect(contextPath+"/user_list");
		}
		
	}
	
}
