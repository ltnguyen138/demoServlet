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



@WebServlet("/Them-moi-chi-tiet-hoa-don")
public class CthdCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public CthdCreateServlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/cthdCreateView.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHDStr=(String) request.getParameter("maHD");
		String MaHHStr=(String) request.getParameter("maHH");
		String SoLuongStr=(String) request.getParameter("soLuong");
		int MaHD=0;
		int MaHH=0;
		int SoLuong=0;
		try {
			MaHD=  Integer.parseInt(MaHDStr);
			MaHH=  Integer.parseInt(MaHHStr);
			SoLuong=  Integer.parseInt(SoLuongStr);
			
		}catch (Exception e) {
		}
		
		cthd cthd= new cthd(MaHD,MaHH,SoLuong);
		String errorString=null;
		if (errorString==null) {
			try {
				cthdDBUtils.insertCthd(conn, cthd);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("cthd", cthd);
		
		response.sendRedirect(request.getContextPath()+"/Danh-sach-chi-tiet-hoa-don");
	}
	

}
