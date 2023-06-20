package ctphieunhap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQLConnection.MySQLConnection;

@WebServlet("/Xoa-chi-tiet-phieu-nhap")
public class CTPhieunhapDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieunhapStr=(String) request.getParameter("mpn");
		String mahanghoaStr=(String) request.getParameter("mhh");
		long maphieunhap=0;
		int mahanghoa=0;
		maphieunhap=Long.parseLong(maphieunhapStr);
		mahanghoa=Integer.parseInt(mahanghoaStr);
		try {
			ctphieunhapDBUtils.deleteCtphieunhap(conn, maphieunhap, mahanghoa);;
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		response.sendRedirect(request.getContextPath()+"/Them-moi-phieu-nhap?mpn="+maphieunhap);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
