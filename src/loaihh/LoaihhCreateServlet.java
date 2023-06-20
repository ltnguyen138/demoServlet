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



@WebServlet("/Them-moi-loai-hang-hoa")
public class LoaihhCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoaihhCreateServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/loaihhCreateView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		if (errorString==null) {
			try {
				loaihhDBUtils.insertLoaihh(conn, loaihh);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("loaihh", loaihh);
		
		response.sendRedirect(request.getContextPath()+"/Danh-sach-loai-hang-hoa");
	}

}
