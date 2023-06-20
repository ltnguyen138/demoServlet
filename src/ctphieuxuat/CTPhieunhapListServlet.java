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
import ctphieuxuat.ctphieuxuat;
import ctphieuxuat.ctphieuxuatDBUtils;
import phieuxuat.phieuxuat;
import phieuxuat.phieuxuatDBUtils;

@WebServlet("/Chi-tiet-phieu-xuat")
public class CTPhieunhapListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String maphieuxuatStr=(String) request.getParameter("mpx");
		long maphieuxuat=0;
		try{
		   maphieuxuat= Long.parseLong(maphieuxuatStr);
		} catch(NumberFormatException ex){ // handle your exception
		    ex.printStackTrace();
		}
		float tongthanhtien=0;
		float thanhtien=0;
		String errorString=null;
		List<ctphieuxuat> listct=null;
		phieuxuat phieuxuat=null;
		try {
			Connection conn = MySQLConnection.getMySQLConnection();
			phieuxuat=phieuxuatDBUtils.findPhieuxuat(conn, maphieuxuat);
			listct=ctphieuxuatDBUtils.findCtphieuxuat(conn, maphieuxuat);
			for (ctphieuxuat ctphieuxuat : listct) {
				thanhtien=ctphieuxuat.getDongia()*ctphieuxuat.getSoluong();
				tongthanhtien+=thanhtien;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("thanhtien", tongthanhtien);
		request.setAttribute("errorString", errorString);
		request.setAttribute("ctphieuxuatList", listct);
		request.setAttribute("phieuxuat", phieuxuat);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/ctphieuxuatListView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
