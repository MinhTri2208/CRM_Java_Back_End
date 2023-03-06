package com.cybersoft.crm_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybersoft.crm_project.model.TaskModel;
import com.cybersoft.crm_project.model.UserModel;
import com.cybersoft.crm_project.pojo.DuAn;
import com.cybersoft.crm_project.pojo.Task;
@WebServlet(urlPatterns = {"/add_task","/task_delete","/view_task","/update_task","/task_list","/add_task_view","/view_task_update",
		"/view_task_by_status","/search_task_by_id_task","/search_task","/view_task_by_id_NV","/view_task_by_id_DuAn","/view_task_detail",
		"/search_task_by_id_tasks"})
public class TaskController extends HttpServlet{
	
	TaskModel taskModel = new TaskModel();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		String contextPath = req.getContextPath();
		
		if (path.equals("/task_list")) {
			List<Task> tasks= taskModel.viewAllTask();
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		if (path.equals("/search_task_by_id_task")) {
			String id_task = req.getParameter("id_task");
			int id_task1 =Integer.parseInt(id_task);
			List<Task> tasks= taskModel.searchAllTaskByID(id_task1);
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		if (path.equals("/search_tasks")) {
			String id_task = req.getParameter("id_task");
			int id_task1 =Integer.parseInt(id_task);
			List<Task> tasks= taskModel.searchAllTaskByID(id_task1);
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		if (path.equals("/search_task_by_id_tasks")) {
			String id_task = req.getParameter("id_task");
			int id_task1 =Integer.parseInt(id_task);
			List<Task> tasks= taskModel.searchAllTaskByID(id_task1);
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		if(path.equals("/search_task")) {
			
			String id_taskString= req.getParameter("id_task");
			String tenCongViec = req.getParameter("tenCongViec");
			String tenTrangThai =req.getParameter("tentrangThai");
			String tenNhanVien=req.getParameter("tenNhanVien");
			if (id_taskString!=null) {
				int id_task1 =Integer.parseInt(id_taskString);
				List<Task> tasks= taskModel.searchAllTaskByID(id_task1);
				req.setAttribute("listTasks", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/task2.jsp").forward(req, resp);
			}
			if (tenCongViec!=null) {
				List<Task> tasks= taskModel.searchAllTaskByName(tenCongViec);
				req.setAttribute("listTasks", tasks);
				System.out.println(tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/task2.jsp").forward(req, resp);
			}
			if (tenTrangThai!=null) {
				List<Task> tasks= taskModel.searchAllTaskByStatus(tenTrangThai);
				req.setAttribute("listTasks", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/task2.jsp").forward(req, resp);
			}
			if (tenNhanVien!=null) {
				tenNhanVien.trim();
				tenNhanVien="'"+tenNhanVien+"'";
				System.out.println(tenNhanVien);
				List<Task> tasks= taskModel.searchAllTaskByNameUser(tenNhanVien);
				req.setAttribute("listTasks", tasks);
				req.getRequestDispatcher("./LayoutCrm_admin/task2.jsp").forward(req, resp);
			}
		}
//		if (path.equals("/view_task_by_status")) {
//			String name = req.getParameter("tentrangThai");
//			List<Task> tasks= taskModel.viewAllTaskByTrangThai(name);
//			req.setAttribute("listTasks", tasks);
//			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
//		}
		if (path.equals("/view_task_by_id_NV")) {
			String id = req.getParameter("id_NV");
			Integer id1= Integer.parseInt(id);
			List<Task> tasks= taskModel.viewAllTaskById_NV(id1);
//			req.setAttribute("listTasks", tasks);
//			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		if (path.equals("/view_task_by_id_DuAn")) {
			String id = req.getParameter("id_DuAn");
			Integer id1= Integer.parseInt(id);
			List<Task> tasks= taskModel.viewAllTaskById_DuAn(id1);
//			req.setAttribute("listTasks", tasks);
//			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}
		
		if (path.equals("/add_task_view")) {
			req.getRequestDispatcher("./LayoutCrm_admin/task-add.jsp").forward(req, resp);
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
			List<Task> tasks= taskModel.viewAllTask();
			req.setAttribute("listTasks", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task.jsp").forward(req, resp);
		}

		if (path.equals("/view_task")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task-view.jsp").forward(req, resp);
		}
		if (path.equals("/view_task_update")) {
			String id = req.getParameter("id_task");
			Integer id1= Integer.parseInt(id);
			Task tasks= taskModel.SearchByID(id1);
			req.setAttribute("view_task", tasks);
			req.getRequestDispatcher("./LayoutCrm_admin/task-update.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String contextPath = req.getContextPath();
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		if(path.equals("/add_task")) {
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
				resp.sendRedirect(contextPath+"/add_task_view");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (path.equals("/update_task")) {
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
				resp.sendRedirect(contextPath+"/task_list");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
