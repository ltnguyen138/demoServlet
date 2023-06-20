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



@WebServlet("/Cap-nhat-chi-tiet-hoa-don")
public class CthdUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CthdUpdateServlet() {
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
			cthd=cthdDBUtils.findCthd(conn, MaHD);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if (errorString!=null&& cthd==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-chi-tiet-hoa-don");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("cthd", cthd);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editCthdView.jsp");
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
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editCthdView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-chi-tiet-hoa-don");
		}
	}

}
