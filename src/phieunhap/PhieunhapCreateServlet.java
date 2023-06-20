package phieunhap;

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

import ctphieunhap.ctphieunhap;
import ctphieunhap.ctphieunhapDBUtils;
import hanghoa.hanghoa;
import hanghoa.hanghoaDBUtils;
import ncc.NccCreateServlet;
import ncc.ncc;
import ncc.nccDBUtils;
import taoma.taoma;

@WebServlet("/Them-moi-phieu-nhap")
public class PhieunhapCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Connection conn = MySQLConnection.getMySQLConnection();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String maphieunhapStr=(String) request.getParameter("mpn");
		if(maphieunhapStr==null) {
			 maphieunhapStr= taoma.taoma();
		}
		long maphieunhap=0;
		try{
		   maphieunhap= Long.parseLong(maphieunhapStr);
		} catch(NumberFormatException ex){ // handle your exception
		    ex.printStackTrace();
		}
		List<ncc> danhsachncc=null;
		try {
			danhsachncc=nccDBUtils.queryNcc(conn);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("danhsachncc", danhsachncc);
		Object manv = session.getAttribute("id");
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String ngaylapphieu= time.format(customFormatter);
		request.setAttribute("maphieunhap", maphieunhap);
		request.setAttribute("manv", manv);
		request.setAttribute("ngaylapphieu", ngaylapphieu);
		float tongthanhtien=0;
		float thanhtien=0;
		String errorString=null;
		List<ctphieunhap> list=null;
		try {
			
			list=ctphieunhapDBUtils.findCtphieunhap(conn, maphieunhap);
			for (ctphieunhap ctphieunhap : list) {
				thanhtien=ctphieunhap.getDongia()*ctphieunhap.getSoluong();
				tongthanhtien+=thanhtien;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		String tongthanhtienStr= Float.toString(tongthanhtien);
		request.setAttribute("thanhtien", tongthanhtienStr);
		request.setAttribute("errorString", errorString);
		request.setAttribute("ctphieunhapList", list);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/phieunhap.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String maphieunhapStr=new String(request.getParameter("maphieunhap").getBytes("iso-8859-1"), "utf-8") ;
		String manccStr=(String) request.getParameter("mancc");
		String manvStr=(String) request.getParameter("manv");
		String ngaylapphieu=(String) request.getParameter("ngaylapphieu");
		String thanhtienStr=(String) request.getParameter("thanhtien");
		long maphieunhap=0;
		int mancc=0;
		int manv=0;
		float thanhtien=0;
		try {
			maphieunhap=  Long.parseLong(maphieunhapStr);
			mancc=Integer.parseInt(manccStr);
			manv=  Integer.parseInt(manvStr);
			thanhtien=  Float.parseFloat(thanhtienStr);
		}catch (Exception e) {
		}
		phieunhap phieunhap= new phieunhap(maphieunhap,mancc,manv,ngaylapphieu,thanhtien);
		String errorString=null;
		if (errorString==null) {
			try {
				phieunhapDBUtils.insertPhieunhap(conn, phieunhap);
			} catch (SQLException e) {
			// TODO Auto-generated catch block		
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		List<ctphieunhap> list=null;
		try {
			list=ctphieunhapDBUtils.findCtphieunhap(conn, maphieunhap);
			for (ctphieunhap ctphieunhap : list) {
				hanghoa hanghoa =null;
				hanghoa=hanghoaDBUtils.findHanghoa(conn, ctphieunhap.getMahanghoa());
				if (hanghoa==null) {
				hanghoa=new hanghoa(ctphieunhap.getMahanghoa(),ctphieunhap.getTenhanghoa(),mancc, ctphieunhap.getSoluong(),ctphieunhap.getDongia());
				hanghoaDBUtils.insertHanghoa(conn, hanghoa);
				}
				else {
					int soluonghh=0;
					soluonghh= hanghoa.getSoluong();
					soluonghh+=ctphieunhap.getSoluong();
					hanghoaDBUtils.updateSLHanghoa(conn, hanghoa.getMaHH(), soluonghh);
				}
		}
			
		} catch (SQLException e) {
		// TODO Auto-generated catch block		
			e.printStackTrace();
			errorString=e.getMessage();
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("pn", phieunhap);
		response.sendRedirect(request.getContextPath()+"/Danh-sach-phieu-nhap");
	}

}
