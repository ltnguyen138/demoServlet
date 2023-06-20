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


@WebServlet("/Xoa-loai-hang-hoa")
public class LoaihhDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoaihhDeleteServlet() {
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
			loaihhDBUtils.deleteLoaihh(conn, MaLoaihh);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/deleteLoaihhView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-loai-hang-hoa");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
