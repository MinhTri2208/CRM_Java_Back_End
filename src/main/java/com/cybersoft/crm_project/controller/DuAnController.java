package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.crm_project.model.DuAnModel;
import com.cybersoft.crm_project.pojo.DuAn;
import com.cybersoft.crm_project.pojo.Roles;
import com.cybersoft.crm_project.pojo.Task;
@WebServlet(urlPatterns = {"/search_duan","/add_duan","/add_duan_view","/delete_duan","/update_duan","/view_duan","/duan_list","/view_update_duan",
		"/duan_detail"})
public class DuAnController extends HttpServlet{
	DuAnModel duAnModel = new DuAnModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String contextPath = req.getContextPath();

		if (path.equals("/delete_duan")) {
			
			String id_DuAn =req.getParameter("id_DuAn");
			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			DuAn duAn =new DuAn(id_DuAn1);
			try {
				duAnModel.deleteDuAn(duAn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.sendRedirect(contextPath+"/duan_list");
		}
		if (path.equals("/duan_list")) {
			List<DuAn> duAns= duAnModel.viewAllDuAns();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listDuAns", duAns);
			req.getRequestDispatcher("./LayoutCrm_admin/groupwork.jsp").forward(req, resp);
		}
		//search List
		if(path.equals("/search_duan")) {
			String id_DuAn= req.getParameter("id_DuAn");
			String tenDuAn = req.getParameter("id_name");
			String tenTrangThai = req.getParameter("tenTrangThai");
			if (id_DuAn!=null) {
				List<DuAn> tasks = null;
				try {
					tasks = duAnModel.searchById(id_DuAn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("listDuAns", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork2.jsp").forward(req, resp);
			}
			if (tenDuAn!=null) {
				List<DuAn> tasks = null;
				tenDuAn="'"+tenDuAn+"'";
				try {
					tasks = duAnModel.searchByName(tenDuAn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("listDuAns", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork2.jsp").forward(req, resp);
			}
			if (tenTrangThai!=null) {
				List<DuAn> tasks = null;
				try {
					tasks = duAnModel.searchByStatus(tenTrangThai);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("listDuAns", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork2.jsp").forward(req, resp);
			}
		}
		if (path.equals("/view_duan")) {
			
			String id_DuAn =req.getParameter("id_DuAn");
			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			DuAn duAn= duAnModel.SearchAllDuAnByID(id_DuAn1);	
			req.setAttribute("duAn", duAn);
			req.getRequestDispatcher("./LayoutCrm_admin/groupwork-view.jsp").forward(req, resp);
		}
		if (path.equals("/view_update_duan")) {
			
			String id_DuAn =req.getParameter("id_DuAn");
			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			DuAn duAn= duAnModel.SearchAllDuAnByID(id_DuAn1);	
			req.setAttribute("duAn", duAn);
			req.getRequestDispatcher("./LayoutCrm_admin/groupwork-update.jsp").forward(req, resp);	
		}
		if (path.equals("/duan_detail")) {
			String id = req.getParameter("id");
			String duAnName= duAnModel.tenDAByID(id);
			System.out.println(duAnName);
			int count=duAnModel.count_duanCHT(id);
			System.out.println(count);
			int count1=duAnModel.count_duanDHT(id);
			System.out.println(count1);
			int count2=duAnModel.count_duanDTH(id);
			System.out.println(count2);
			List<Task> taskDHT= duAnModel.detail_duanDHT(id);
			List<Task> taskDTH= duAnModel.detail_duanDTH(id);
			List<Task> taskCHT= duAnModel.detail_duanCHT(id);
			req.setAttribute("duAnName", duAnName);
			req.setAttribute("taskDHT", taskDHT);
			req.setAttribute("taskDTH", taskDTH);
			req.setAttribute("taskCHT", taskCHT);
			req.setAttribute("count", count);
			req.setAttribute("count1", count1);
			req.setAttribute("count2", count2);
			req.getRequestDispatcher("./LayoutCrm_admin/groupwork-details.jsp").forward(req, resp);
		} 
		if(path.equals("/search_task")) {
			
			String id_duan= req.getParameter("id_DuAn");
			String tenDuAn = req.getParameter("tenDuAn");
			String tenTrangThai =req.getParameter("tenTrangThai");
			if (id_duan!=null) {
				int id_task1 =Integer.parseInt(id_duan);
				DuAn duan= duAnModel.SearchAllDuAnByID(id_task1);
				req.setAttribute("listDuAn", duan);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork.jsp").forward(req, resp);
			}
			if (tenDuAn!=null) {
				List<DuAn> duAns= duAnModel.searchDAByName(tenDuAn);
				req.setAttribute("listDuAn", duAns);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork.jsp").forward(req, resp);
			}
			if (tenTrangThai!=null) {
				List<DuAn> duAns= duAnModel.searchDAByStatus(tenTrangThai);
				req.setAttribute("listDuAn", duAns);
				req.getRequestDispatcher("./LayoutCrm_admin/groupwork.jsp").forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		if (path.equals("/add_duan")) {

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
			resp.sendRedirect(contextPath+"/duan_list");
		}

		
		if (path.equals("/update_duan")) {
			
			String id_DuAn =req.getParameter("id_DuAn");
			Integer id_DuAn1= Integer.parseInt(id_DuAn);
			String tenDuAn =req.getParameter("tenDuAn");
			String tenTrangThai =req.getParameter("tenTrangThai");
			String ngayBatDau =req.getParameter("ngayBatDau");
			String ngayKetThuc =req.getParameter("ngayKetThuc");
			DuAn duAn =new DuAn(id_DuAn1,tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
			duAnModel.updateDuAn(duAn);
			resp.sendRedirect(contextPath+"/duan_list");
		}
		
//		if (path.equals("/add_duan")) {
//
//			String tenDuAn =req.getParameter("tenDuAn");
//			String tenTrangThai =req.getParameter("tenTrangThai");
//			String ngayBatDau =req.getParameter("ngayBatDau");
//			String ngayKetThuc =req.getParameter("ngayKetThuc");
//			DuAn duAn =new DuAn(tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
//			try {
//				duAnModel.insertDuAn(duAn);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			resp.sendRedirect(contextPath+"/duan_list");
//		}

		
//		if (path.equals("/update_duan")) {
//			String tenDuAn =req.getParameter("tenDuAn");
//			String tenTrangThai =req.getParameter("tenTrangThai");
//			String ngayBatDau =req.getParameter("ngayBatDau");
//			String ngayKetThuc =req.getParameter("ngayKetThuc");
//			DuAn duAn =new DuAn(tenDuAn, tenTrangThai, ngayBatDau, ngayKetThuc);
//			duAnModel.updateDuAn(duAn);
//			resp.sendRedirect(contextPath+"/view_duan");
//		}	
	}
}
