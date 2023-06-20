package ctphieuxuat;

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
import hanghoa.hanghoa;
import hanghoa.hanghoaDBUtils;

@WebServlet("/Them-moi-chi-tiet-phieu-xuat")
public class CtphieuxuatCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		List<hanghoa> listhanghoa=null;
		try {
			listhanghoa = hanghoaDBUtils.queryHanghoa(conn);
		}catch (Exception e) {
		}		
		String maphieuxuatStr=(String) request.getParameter("mpx");
		request.setAttribute("maphieuxuat", maphieuxuatStr);
		request.setAttribute("listhanghoa", listhanghoa);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/ctphieuxuatCreateView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieuxuatStr=(String) request.getParameter("maphieuxuat");
		String mahanghoaStr=(String) request.getParameter("mahanghoa");
		String soluongStr=(String) request.getParameter("soluong");
		long maphieuxuat=0;
		int mahanghoa=0;
		int soluong=0;
		String errorsl="";
		try {
			maphieuxuat=  Long.parseLong(maphieuxuatStr);
			mahanghoa=  Integer.parseInt(mahanghoaStr);
			soluong=  Integer.parseInt(soluongStr);
		}catch (Exception e) {
		}
		hanghoa hanghoa=null;
		try {
			hanghoa=hanghoaDBUtils.findHanghoa(conn, mahanghoa);
		}catch (Exception e) {
		}		
		int soluonghh=hanghoa.getSoluong();
		int dongia=(int)hanghoa.getDonGia();
		if(soluonghh>=soluong) {
			ctphieuxuat ctphieuxuat= new ctphieuxuat(maphieuxuat,mahanghoa,soluong,dongia);
			String errorString=null;
			if (errorString==null) {
				try {
					ctphieuxuatDBUtils.insertCtphieuxuat(conn, ctphieuxuat);
				} catch (SQLException e) {
					e.printStackTrace();
					errorString=e.getMessage();
				}
			}			
			request.setAttribute("errorString", errorString);
			request.setAttribute("cthd", ctphieuxuat);
			request.setAttribute("mpx",maphieuxuat);
			request.setAttribute("errorsl", errorsl);
			response.sendRedirect(request.getContextPath()+"/Them-moi-phieu-xuat?mpx="+maphieuxuat);	
		}
		else {
			errorsl ="Số lượng hàng hóa vượt quá số lượng hàng hóa trong kho";
			List<hanghoa> listhanghoa=null;
			try {
				listhanghoa = hanghoaDBUtils.queryHanghoa(conn);
			}catch (Exception e) {
			}
			request.setAttribute("listhanghoa",listhanghoa);
			request.setAttribute("maphieuxuat",maphieuxuat);
			request.setAttribute("errorsl", errorsl);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/ctphieuxuatCreateView.jsp");
			dispatcher.forward(request, response);	
		}		
	}
}
