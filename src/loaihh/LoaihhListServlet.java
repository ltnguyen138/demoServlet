package loaihh;

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

import MySQLConnection.MySQLConnection;



@WebServlet("/Danh-sach-loai-hang-hoa")
public class LoaihhListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoaihhListServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at:").append(request.getContextPath());
		
		String errorString=null;
		List<loaihh> list=null;
		try {
			Connection conn = MySQLConnection.getMySQLConnection();
			list=loaihhDBUtils.queryLoaihh(conn);
		} catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("loaihhList", list);
		
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/loaihhListView.jsp");
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
