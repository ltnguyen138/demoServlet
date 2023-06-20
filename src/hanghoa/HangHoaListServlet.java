package hanghoa;

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

@WebServlet("/Danh-sach-hang-hoa")
public class HangHoaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HangHoaListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		Connection conn = MySQLConnection.getMySQLConnection();
		String errorString=null;
		List<hanghoa> list=null;
		String searchStr=(String) request.getParameter("search");
		System.out.print(searchStr);
		if(searchStr!=null) {
			int search=0;
			try {
			search=  Integer.parseInt(searchStr);	
			list= hanghoaDBUtils.searchHanghoa(conn, search);	
			request.setAttribute("hanghoaList", list);
			}catch (Exception e) {
			}
		}
		else {
			try {			
			list=hanghoaDBUtils.queryHanghoa(conn);
			request.setAttribute("errorString", errorString);
			request.setAttribute("hanghoaList", list);
			} catch(SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();						
			}
		}			
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/hanghoaListView.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
