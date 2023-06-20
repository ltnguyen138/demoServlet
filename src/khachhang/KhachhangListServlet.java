package khachhang;

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

@WebServlet("/Danh-sach-khach-hang")
public class KhachhangListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KhachhangListServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		String searchStr=(String) request.getParameter("search");
		String errorString=null;
		List<khachhang> list=null;
		if(searchStr!=null) {
			int search=0;
			try {
			search=  Integer.parseInt(searchStr);	
			list= khachhangDBUtils.searchKhachhang(conn, search);	
			request.setAttribute("khachhangList", list);
			}catch (Exception e) {
			}
		}
		else {
			try {
			
			list=khachhangDBUtils.queryKhachhang(conn);
			} catch(SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();
			}
			request.setAttribute("errorString", errorString);
			request.setAttribute("name", objUsername);
			request.setAttribute("khachhangList", list);
		}
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/khachhangListView.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
