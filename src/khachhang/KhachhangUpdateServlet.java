package khachhang;

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

@WebServlet("/Cap-nhat-khach-hang")
public class KhachhangUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public KhachhangUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String MaKHStr=(String) request.getParameter("MaKH");
		int MaKH=0;
		MaKH=  Integer.parseInt(MaKHStr);
		khachhang khachhang =null;
		String errorString=null;
		try {
			khachhang=khachhangDBUtils.findKhachhang(conn,MaKH);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		if (errorString!=null&& khachhang==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-khach-hang");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", khachhang);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editKhachhangView.jsp");
		dispatcher.forward(request, response);		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaKHStr=(String) request.getParameter("maKH");
		String TenKH=new String(request.getParameter("tenKH").getBytes("iso-8859-1"), "utf-8");
		String EmailKH=(String) request.getParameter("emailKH");
		String SdtKH=(String) request.getParameter("sdtKH");
		int MaKH=0;
		try {
			MaKH=  Integer.parseInt(MaKHStr);
		}catch (Exception e) {
		}		
		khachhang khachhang= new khachhang(MaKH,TenKH,EmailKH,SdtKH);
		String errorString=null;
		try {
			khachhangDBUtils.updateKhachhang(conn, khachhang);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", khachhang);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editKhachhangView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-khach-hang");
		}
	}
}
