package cthd;

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



@WebServlet("/Danh-sach-chi-tiet-hoa-don")
public class CthdListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CthdListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		String errorString=null;
		List<cthd> list=null;
		try {
			Connection conn = MySQLConnection.getMySQLConnection();
			list=cthdDBUtils.queryCthd(conn);
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("cthdList", list);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/cthdListView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
