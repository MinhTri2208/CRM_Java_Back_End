package com.cybersoft.crm_project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cybersoft.crm_project.model.UserModel;
import com.cybersoft.crm_project.pojo.NhanVien;
import com.cybersoft.crm_project.pojo.User;

@WebServlet(urlPatterns = {"/login","/admin_login","/leader_login","/member_login"})
public class LoginController extends HttpServlet{
	UserModel userModel = new UserModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path =req.getServletPath();
		if(path.equals("/admin_login")) {
			req.getRequestDispatcher("./LayoutCrm_admin/index.jsp").forward(req, resp);
		}
		if(path.equals("/leader_login")) {
			req.getRequestDispatcher("./LayoutCrm_leader/index.jsp").forward(req, resp);
		}
		if(path.equals("/member_login")) {
			req.getRequestDispatcher("./LayoutCrm_member/index.jsp").forward(req, resp);
		}
		if(path.equals("/login")) {
			req.getRequestDispatcher("./LayoutCrm_admin/login_admin.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String emailString= req.getParameter("email");
		String passwordString=req.getParameter("matkhau");
		
		System.out.println("email: "+emailString+"\npassword: "+passwordString);
		
		NhanVien nhanVien=userModel.Search(emailString, passwordString);
		
		if(nhanVien!=null && nhanVien.getId_role()==0) {
			HttpSession session=req.getSession();
			System.out.println(nhanVien);
			session.setAttribute("member", nhanVien);
			session.setMaxInactiveInterval(6000);
			int id= nhanVien.getId_NV();
			String idString=String.valueOf(id);
//			Cookie c = new Cookie("member", idString);
//			c.setMaxAge(1800);
//			resp.addCookie(c);
			//req.setAttribute("member", nhanVien.getId_NV());
			//req.getRequestDispatcher("./LayoutCrm_admin/login_admin.jsp").forward(req, resp);
			resp.sendRedirect(req.getContextPath()+"/member_login");
			
		}
		else if(nhanVien!=null && nhanVien.getId_role()==1) {
			HttpSession session=req.getSession();
			session.setAttribute("leader", nhanVien);
			session.setMaxInactiveInterval(600);
			resp.sendRedirect(req.getContextPath()+"/leader_login");
			
		}else if(nhanVien!=null && nhanVien.getId_role()==2) {
			resp.sendRedirect(req.getContextPath()+"/admin_login");
			HttpSession session=req.getSession();
			session.setAttribute("email", emailString);
			session.setMaxInactiveInterval(600);
			
		}else {
			System.out.println("đăng nhập thất bại");
		}

	}
}
