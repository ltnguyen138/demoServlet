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

@WebServlet("/Them-moi-nhan-vien")
public class NhanvienCreateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/nhanvienCreateView.jsp");
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
		if (errorString==null) {
			try {
				userDBUtils.insertUser(conn, user);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", user);
		response.sendRedirect(request.getContextPath()+"/Danh-sach-nhan-vien");
	}

}
