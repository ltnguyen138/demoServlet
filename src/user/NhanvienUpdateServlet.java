package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQLConnection.MySQLConnection;

@WebServlet("/Cap-nhat-nhan-vien")
public class NhanvienUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String idStr=(String) request.getParameter("id");
		int id=0;
		id=  Integer.parseInt(idStr);
		user user =null;
		String errorString=null;
		try {
			user=userDBUtils.findUser(conn,id);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if (errorString!=null&& user==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-nhan-vien");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("nhanvien", user);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editNhanvienView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String idStr=(String) request.getParameter("id");
		String tennv=new String(request.getParameter("tennv").getBytes("iso-8859-1"), "utf-8");
		String sdtnv=(String) request.getParameter("sdtnv");
		String username=(String) request.getParameter("username");
		String password=(String) request.getParameter("password");
		String role="user";
		int id=0;
		try {
			id=  Integer.parseInt(idStr);
		}catch (Exception e) {
		}
		
		user user= new user(id,tennv,sdtnv,username,password,role);
		String errorString=null;
		try {
			userDBUtils.updateUser(conn, user);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("nhanvien", user);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editNhanvienView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-nhan-vien");
		}
	}
}
