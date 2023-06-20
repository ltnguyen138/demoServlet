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



@WebServlet("/Them-moi-hoa-don")
public class HoadonCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public HoadonCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/hoadonCreateView.jsp");
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
				hoadonDBUtils.insertHoadon(conn, hoadon);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("hoadon", hoadon);
		
		response.sendRedirect(request.getContextPath()+"/Danh-sach-hoa-don");
	}

}
