package phieuxuat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MySQLConnection.MySQLConnection;

import ctphieuxuat.ctphieuxuat;
import ctphieuxuat.ctphieuxuatDBUtils;
import hanghoa.hanghoa;
import hanghoa.hanghoaDBUtils;
import khachhang.khachhang;
import khachhang.khachhangDBUtils;
import taoma.taoma;

@WebServlet("/Them-moi-phieu-xuat")
public class PhieuxuatCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Connection conn = MySQLConnection.getMySQLConnection();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String maphieuxuatStr=(String) request.getParameter("mpx");
		if(maphieuxuatStr==null) {
			 maphieuxuatStr= taoma.taoma();
		}
		long maphieuxuat=0;
		try{
		   maphieuxuat= Long.parseLong(maphieuxuatStr);
		} catch(NumberFormatException ex){ // handle your exception
		    ex.printStackTrace();
		}
		List<khachhang> listkhachhang =null;
		try {
			listkhachhang=khachhangDBUtils.queryKhachhang(conn);
		}catch (Exception e) {

		}
		request.setAttribute("listkhachhang", listkhachhang);
		Object manv = session.getAttribute("id");
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngaylapphieu= time.format(customFormatter);
		request.setAttribute("maphieuxuat", maphieuxuat);
		request.setAttribute("manv", manv);
		request.setAttribute("ngaylapphieu", ngaylapphieu);
		float tongthanhtien=0;
		float thanhtien=0;
		String errorString=null;
		List<ctphieuxuat> list=null;
		try {
			
			list=ctphieuxuatDBUtils.findCtphieuxuat(conn, maphieuxuat);
			for (ctphieuxuat ctphieuxuat : list) {
				thanhtien=ctphieuxuat.getDongia()*ctphieuxuat.getSoluong();
				tongthanhtien+=thanhtien;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		String tongthanhtienStr= Float.toString(tongthanhtien);
		request.setAttribute("thanhtien", tongthanhtienStr);
		request.setAttribute("errorString", errorString);
		request.setAttribute("ctphieuxuatList", list);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/phieuxuat.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieuxuatStr= (String)request.getParameter("maphieuxuat");
		String makhStr=(String) request.getParameter("makh");
		String manvStr=(String) request.getParameter("manv");
		String ngaylapphieu=(String) request.getParameter("ngaylapphieu");
		String thanhtienStr=(String) request.getParameter("thanhtien");
		System.out.print("ma"+maphieuxuatStr+"kh"+makhStr+"nv"+manvStr+"t"+thanhtienStr);
		long maphieuxuat=0;
		int makh=0;
		int manv=0;
		float thanhtien=0;
		try {
			maphieuxuat=  Long.parseLong(maphieuxuatStr);
			makh=Integer.parseInt(makhStr);
			manv=  Integer.parseInt(manvStr);
			thanhtien=  Float.parseFloat(thanhtienStr);
		}catch (Exception e) {
		}
		phieuxuat phieuxuat= new phieuxuat(maphieuxuat,makh,manv,ngaylapphieu,thanhtien);
		String errorString=null;
		if (errorString==null) {
			try {
				phieuxuatDBUtils.insertPhieuxuat(conn, phieuxuat);
			} catch (SQLException e) {	
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		List<ctphieuxuat> list=null;
		try {
			list=ctphieuxuatDBUtils.findCtphieuxuat(conn, maphieuxuat);
			for (ctphieuxuat ctphieuxuat : list) {
				hanghoa hanghoa =null;
				hanghoa=hanghoaDBUtils.findHanghoa(conn, ctphieuxuat.getMahanghoa());
				
				int soluonghh=0;
				soluonghh= hanghoa.getSoluong();
				soluonghh-=ctphieuxuat.getSoluong();
				if(soluonghh!=0)
					hanghoaDBUtils.updateSLHanghoa(conn, hanghoa.getMaHH(), soluonghh);
				else
					hanghoaDBUtils.deleteHanghoa(conn, hanghoa.getMaHH());			
		}
			
		} catch (SQLException e) {		
			e.printStackTrace();
			errorString=e.getMessage();
		}				
		request.setAttribute("errorString", errorString);
		request.setAttribute("px", phieuxuat);
		response.sendRedirect(request.getContextPath()+"/Danh-sach-phieu-xuat");
	}
}
