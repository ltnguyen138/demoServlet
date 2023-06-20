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

@WebServlet("/Cap-nhat-chi-tiet-phieu-xuat")
public class CTPhieuXuatUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieuxuatStr=(String) request.getParameter("mpx");
		String mahanghoaStr=(String) request.getParameter("mhh");
		long maphieuxuat=0;
		int mahanghoa=0;
		maphieuxuat=Long.parseLong(maphieuxuatStr);
		mahanghoa=Integer.parseInt(mahanghoaStr);
		ctphieuxuat ctphieuxuat = null;
		try {
			ctphieuxuat= ctphieuxuatDBUtils.findCtphieuxuat(conn, maphieuxuat, mahanghoa);
		}catch(SQLException e) {
			e.printStackTrace();			
		}
		request.setAttribute("ctphieuxuat", ctphieuxuat);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editCtphieuxuatView.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieuxuatStr=(String) request.getParameter("maphieuxuat");
		String mahanghoaStr=(String) request.getParameter("mahanghoa");
		String soluongStr=(String) request.getParameter("soluong");
		String dongiaStr=(String) request.getParameter("dongia");
		System.out.print(maphieuxuatStr+mahanghoaStr+soluongStr+"s"+dongiaStr);
		long maphieuxuat=0;
		int mahanghoa=0;
		int soluong=0;
		int dongia=0;
		try {
			maphieuxuat=  Long.parseLong(maphieuxuatStr);
			mahanghoa=  Integer.parseInt(mahanghoaStr);
			soluong=  Integer.parseInt(soluongStr);
			dongia=  Integer.parseInt(dongiaStr);
		}catch (Exception e) {
		}
		int soluonghh=0;
		
		try {
			hanghoa hanghoa=null;
			hanghoa=hanghoaDBUtils.findHanghoa(conn, mahanghoa);
			soluonghh=hanghoa.getSoluong();
		}catch (Exception e) {

		}	
		if(soluonghh>=soluong) {
			ctphieuxuat ctphieuxuat= new ctphieuxuat(maphieuxuat,mahanghoa,soluong,dongia);
			String errorString=null;
			if (errorString==null) {
				try {
					ctphieuxuatDBUtils.updateCtphieuxuat(conn, ctphieuxuat);
				} catch (SQLException e) {
					e.printStackTrace();
					errorString=e.getMessage();
				}
			}
			
			request.setAttribute("errorString", errorString);
			request.setAttribute("cthd", ctphieuxuat);
			request.setAttribute("mpx",maphieuxuat);
			
			response.sendRedirect(request.getContextPath()+"/Them-moi-phieu-xuat?mpx="+maphieuxuat);	
		}
		else {
			String errorsl ="Số lượng hàng hóa vượt quá số lượng hàng hóa trong kho";
		
			ctphieuxuat ctphieuxuat= new ctphieuxuat(maphieuxuat,mahanghoa,soluong,dongia);
			request.setAttribute("ctphieuxuat",ctphieuxuat);
			request.setAttribute("errorsl", errorsl);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editCtphieuxuatView.jsp");
			dispatcher.forward(request, response);	
		}
	}

}
