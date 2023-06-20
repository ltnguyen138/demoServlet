package cthd;

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

/**
 * Servlet implementation class CthdDeleteServlet
 */
@WebServlet("/Xoa-chi-tiet-hoa-don")
public class CthdDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CthdDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHDStr=(String) request.getParameter("MaHD");
		int MaHD=0;
		MaHD=  Integer.parseInt(MaHDStr);
		cthd cthd =null;
		String errorString=null;
		try {
			cthdDBUtils.deleteCthd(conn, MaHD);;
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/deleteCthdView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-chi-tiet-hoa-don");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
