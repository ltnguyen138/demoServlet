package hanghoa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySQLConnection.MySQLConnection;

@WebServlet("/Cap-nhat-hang-hoa")
public class HanghoaUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String MaHHStr=(String) request.getParameter("MaHH");
		int MaHH=0;
		MaHH=  Integer.parseInt(MaHHStr);
		hanghoa hanghoa =null;
		String errorString=null;
		try {
			hanghoa=hanghoaDBUtils.findHanghoa(conn, MaHH);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if (errorString!=null&& hanghoa==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-hang-hoa");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("hanghoa", hanghoa);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editHanghoaView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHHStr=(String) request.getParameter("maHH");

		String DonGiaStr=(String) request.getParameter("donGia");
		int MaHH=0;

		float DonGia=0;
		try {
			MaHH=  Integer.parseInt(MaHHStr);
			DonGia=  Float.parseFloat(DonGiaStr);
		}catch (Exception e) {
		}
		String errorString=null;
		try {
			hanghoaDBUtils.updateDGHanghoa(conn, MaHH,DonGia);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editHanghoaView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-hang-hoa");
		}
	}
}
