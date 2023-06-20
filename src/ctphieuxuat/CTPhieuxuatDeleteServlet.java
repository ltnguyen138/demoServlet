package ctphieuxuat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQLConnection.MySQLConnection;

@WebServlet("/Xoa-chi-tiet-phieu-xuat")
public class CTPhieuxuatDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieuxuatStr=(String) request.getParameter("mpx");
		String mahanghoaStr=(String) request.getParameter("mhh");
		long maphieuxuat=0;
		int mahanghoa=0;
		maphieuxuat=Long.parseLong(maphieuxuatStr);
		mahanghoa=Integer.parseInt(mahanghoaStr);
		try {
			ctphieuxuatDBUtils.deleteCtphieuxuat(conn, maphieuxuat, mahanghoa);;
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		response.sendRedirect(request.getContextPath()+"/Them-moi-phieu-xuat?mpx="+maphieuxuat);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
