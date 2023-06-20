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

import MySQLConnection.MySQLConnection;
import ncc.nccDBUtils;

@WebServlet("/Xoa-khach-hang")
public class khachhangDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public khachhangDeleteServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaKHStr=(String) request.getParameter("MaKH");
		int MaKH=0;
		MaKH=  Integer.parseInt(MaKHStr);
		khachhang khachhang =null;
		String errorString=null;
		try {
			khachhangDBUtils.deleteKhachhang(conn, MaKH);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}		
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/deleteKhachhangView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-khach-hang");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
