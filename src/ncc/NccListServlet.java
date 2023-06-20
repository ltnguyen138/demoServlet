package ncc;

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
import javax.servlet.http.HttpSession;

import MySQLConnection.MySQLConnection;

@WebServlet("/Danh-sach-nha-cung-cap")
public class NccListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		response.getWriter().append("Served at:").append(request.getContextPath());
		String searchStr=(String) request.getParameter("search");
		String errorString=null;
		List<ncc> list=null;
		if(searchStr!=null) {
			int search=0;
			try {
			search=  Integer.parseInt(searchStr);	
			list= nccDBUtils.searchNcc(conn, search);	
			request.setAttribute("nccList", list);
			}catch (Exception e) {
			}
		}
		else {
			try {			
			list=nccDBUtils.queryNcc(conn);
			} catch(SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("nccList", list);
		}
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/nccListView.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
