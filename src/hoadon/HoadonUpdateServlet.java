package hoadon;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MySQLConnection.MySQLConnection;



@WebServlet("/Cap-nhat-hoa-don")
public class HoadonUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HoadonUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHDStr=(String) request.getParameter("MaHD");
		int MaHD=0;
		MaHD=  Integer.parseInt(MaHDStr);
		hoadon  hoadon =null;
		String errorString=null;
		try {
			hoadon=hoadonDBUtils.findHoadon(conn, MaHD);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if (errorString!=null&& hoadon==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-hoa-don");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("hoadon", hoadon);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editHoadonView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHDStr=(String) request.getParameter("maHD");
		String MaKHStr=(String) request.getParameter("maKH");
		String ThanhTienStr=(String) request.getParameter("thanhTien");
		String NgayLapHD=(String) request.getParameter("ngayLapHD");
		int MaHD=0;
		int MaKH=0;
		float ThanhTien=0;
		try {
			MaHD=  Integer.parseInt(MaHDStr);
			MaKH=  Integer.parseInt(MaKHStr);
			ThanhTien=  Float.parseFloat(ThanhTienStr);
		}catch (Exception e) {
		}
		
		hoadon hoadon= new hoadon(MaHD,MaKH,ThanhTien,NgayLapHD);
		String errorString=null;
		if (errorString==null) {
			try {
				hoadonDBUtils.updateHoadon(conn, hoadon);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("hoadon", hoadon);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editHoadonView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-hoa-don");
		}
	}

}
