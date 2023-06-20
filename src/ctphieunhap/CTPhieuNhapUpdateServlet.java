package ctphieunhap;

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

@WebServlet("/Cap-nhat-chi-tiet-phieu-nhap")
public class CTPhieuNhapUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String maphieunhapStr=(String) request.getParameter("mpn");
		String mahanghoaStr=(String) request.getParameter("mhh");
		long maphieunhap=0;
		int mahanghoa=0;
		maphieunhap=Long.parseLong(maphieunhapStr);
		mahanghoa=Integer.parseInt(mahanghoaStr);
		ctphieunhap ctphieunhap = null;
		try {
			ctphieunhap= ctphieunhapDBUtils.findCtphieunhap(conn, maphieunhap, mahanghoa);
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		request.setAttribute("ctphieunhap", ctphieunhap);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editCtphieunhapView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieunhapStr=(String) request.getParameter("maphieunhap");
		String mahanghoaStr=(String) request.getParameter("mahanghoa");
		String tenhanghoa=new String(request.getParameter("tenhanghoa").getBytes("iso-8859-1"), "utf-8");
		String soluongStr=(String) request.getParameter("soluong");
		String dongiaStr=(String) request.getParameter("dongia");
		long maphieunhap=0;
		int mahanghoa=0;
		int soluong=0;
		int dongia=0;
		try {
			maphieunhap=  Long.parseLong(maphieunhapStr);
			mahanghoa=  Integer.parseInt(mahanghoaStr);
			soluong=  Integer.parseInt(soluongStr);
			dongia=  Integer.parseInt(dongiaStr);
		}catch (Exception e) {
		}		
		ctphieunhap ctphieunhap= new ctphieunhap(maphieunhap,mahanghoa,tenhanghoa,soluong,dongia);
		String errorString=null;
		if (errorString==null) {
			try {
				ctphieunhapDBUtils.updateCtphieunhap(conn, ctphieunhap);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}		
		request.setAttribute("errorString", errorString);
		request.setAttribute("cthd", ctphieunhap);
		request.setAttribute("mpn",maphieunhap);		
		response.sendRedirect(request.getContextPath()+"/Them-moi-phieu-nhap?mpn="+maphieunhap);
	}
}
