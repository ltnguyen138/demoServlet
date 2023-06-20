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
import phieunhap.phieunhap;
import phieunhap.phieunhapDBUtils;


@WebServlet("/Chi-tiet-phieu-nhap")
public class CTPhieunhapListServletListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String maphieunhapStr=(String) request.getParameter("mpn");
		long maphieunhap=0;
		try{
		   maphieunhap= Long.parseLong(maphieunhapStr);
		} catch(NumberFormatException ex){ // handle your exception
		    ex.printStackTrace();
		}
		float tongthanhtien=0;
		float thanhtien=0;
		String errorString=null;
		List<ctphieunhap> listct=null;
		phieunhap phieunhap=null;
		try {
			Connection conn = MySQLConnection.getMySQLConnection();
			phieunhap=phieunhapDBUtils.findPhieunhap(conn, maphieunhap);
			listct=ctphieunhapDBUtils.findCtphieunhap(conn, maphieunhap);
			for (ctphieunhap ctphieunhap : listct) {
				thanhtien=ctphieunhap.getDongia()*ctphieunhap.getSoluong();
				tongthanhtien+=thanhtien;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("thanhtien", tongthanhtien);
		request.setAttribute("errorString", errorString);
		request.setAttribute("ctphieunhapList", listct);
		request.setAttribute("phieunhap", phieunhap);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/ctphieunhapListView.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
