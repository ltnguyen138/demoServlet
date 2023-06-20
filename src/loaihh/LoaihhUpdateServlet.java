package loaihh;

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



@WebServlet("/Cap-nhat-loai-hang-hoa")
public class LoaihhUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoaihhUpdateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaLoaihhStr=(String) request.getParameter("MaLoaihh");
		int MaLoaihh=0;
		MaLoaihh=  Integer.parseInt(MaLoaihhStr);
		loaihh loaihh =null;
		String errorString=null;
		try {
			loaihh=loaihhDBUtils.findLoaihh(conn,MaLoaihh);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if (errorString!=null&& loaihh==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-loai-hang-hoa");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("loaihh", loaihh);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editLoaihhView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaLoaihhStr=(String) request.getParameter("maLoaihh");
		String TenLoaihh=(String) request.getParameter("tenLoaihh");

		int MaLoaihh=0;
		try {
			MaLoaihh=  Integer.parseInt(MaLoaihhStr);
		}catch (Exception e) {
		}
		
		loaihh loaihh= new loaihh(MaLoaihh,TenLoaihh);
		String errorString=null;
		
		try {
			loaihhDBUtils.updateLoaihh(conn, loaihh);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editLoaihhView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-loai-hang-hoa");
		}
	}

}
