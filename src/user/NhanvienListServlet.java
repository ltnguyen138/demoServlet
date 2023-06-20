package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQLConnection.MySQLConnection;

@WebServlet("/Danh-sach-nhan-vien")
public class NhanvienListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		String searchStr=(String) request.getParameter("search");
		String errorString=null;
		List<user> list=null;
		if(searchStr!=null) {
			int search=0;
			try {
			search=  Integer.parseInt(searchStr);	
			list= userDBUtils.searchUser(conn, search);	
			request.setAttribute("nhanvienList", list);
			}catch (Exception e) {
			}
		}
		else {
			try {
			
			list=userDBUtils.queryUser(conn);
			} catch(SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();
			}
		List<user>list1=null;
		try {
			list1= userDBUtils.searchUser(conn, 1);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("quanly", list1);
			request.setAttribute("errorString", errorString);
			request.setAttribute("nhanvienList", list);
		}	
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/nhanvienListView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
