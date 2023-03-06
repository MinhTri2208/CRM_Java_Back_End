package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.crm_project.model.RoleModel;
import com.cybersoft.crm_project.pojo.DuAn;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.Roles;
import com.cybersoft.crm_project.pojo.Task;
@WebServlet(urlPatterns ={"/search_roles","/role_add","/role_delete","/role_update","/role_view","/role_list","/role_add_view","/role_view_update"})
public class RolesController extends HttpServlet{
	
	RoleModel roleModel=new RoleModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String path =req.getServletPath();
		
		if (path.equals("/role_list")) {
			List<Roles> role= roleModel.viewAllRoles();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listRoles", role);
			req.getRequestDispatcher("./LayoutCrm_admin/role-table.jsp").forward(req, resp);
		}
		//search list
		if(path.equals("/search_roles")) {
			
			String id_role= req.getParameter("id_role");
			String id_name = req.getParameter("id_name");
			if (id_role!=null) {
				List<Roles> tasks = null;
				try {
					tasks = roleModel.searchID(id_role);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("listRoles", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/role-table2.jsp").forward(req, resp);
			}
			if (id_name!=null) {
				List<Roles> tasks = null;
				try {
					tasks = roleModel.searchName(id_name);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				req.setAttribute("listRoles", tasks);
				System.out.println(tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/role-table2.jsp").forward(req, resp);
			}
		}
		//end
		if(path.equals("/role_add_view")) {
			req.getRequestDispatcher("./LayoutCrm_admin/role-add.jsp").forward(req, resp);
		}
		if(path.equals("/role_delete")) {
			String id = req.getParameter("id_role");
			Integer id1= Integer.parseInt(id);
			try {
				roleModel.deleteRoles(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<Roles> role= roleModel.viewAllRoles();
			//System.out.println(nhanViens.getDiaChi());
			req.setAttribute("listRoles", role);
			req.getRequestDispatcher("./LayoutCrm_admin/role-table.jsp").forward(req, resp);
		}
		if(path.equals("/role_view")) {
			String id_role = req.getParameter("id_role");
			int id_role1=Integer.parseInt(id_role);
			System.out.println(id_role);
			Roles roles = new Roles(id_role1);
			req.setAttribute("Roles", roles);
			roleModel.SearchByID(id_role1);
			req.getRequestDispatcher("./LayoutCrm_admin/role_view.jsp").forward(req, resp);
		}
		if(path.equals("/role_view_update")) {
			String id_role = req.getParameter("id_role");
			int id_role1=Integer.parseInt(id_role);
			System.out.println(id_role);
			Roles roles = roleModel.SearchByID(id_role1);
			req.setAttribute("Roles", roles);
			
			req.getRequestDispatcher("./LayoutCrm_admin/role-update.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path =req.getServletPath();
		String contextPath =req.getContextPath();
		
		if(path.equals("/role_add")) {
			String role_id =req.getParameter("id_role");
			Integer role_id1=Integer.parseInt(role_id);
			String role_name = req.getParameter("id_name");
			String mota = req.getParameter("mota");
			Roles roles =new Roles(role_id1,role_name, mota);
			try {
				roleModel.insertRole(roles);
				resp.sendRedirect(contextPath+"/role_add_view");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if(path.equals("/role_update")) {
			String id_role = req.getParameter("id_role");
			int id_role1=Integer.parseInt(id_role);
			System.out.println(id_role);
			String id_name = req.getParameter("id_name");
			String mota = req.getParameter("mota");
			Roles roles = new Roles(id_role1, id_name, mota);
			roleModel.updateRoles(roles);
			resp.sendRedirect(contextPath+"/role_list");
		}
		
	}
}
