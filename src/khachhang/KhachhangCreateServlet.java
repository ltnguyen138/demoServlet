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
import javax.servlet.http.HttpSession;

import MySQLConnection.MySQLConnection;

@WebServlet("/Them-moi-khach-hang")
public class KhachhangCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KhachhangCreateServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/khachhangCreateView.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaKHStr=(String) request.getParameter("maKH");
		String TenKH=new String(request.getParameter("tenKH").getBytes("iso-8859-1"), "utf-8");
		String EmailKH=(String) request.getParameter("emailKH");
		String SdtKH=(String) request.getParameter("sdtKH");
		int MaKH=0;
		try {
			MaKH=  Integer.parseInt(MaKHStr);
		}catch (Exception e) {
		}
		khachhang khachhang= new khachhang(MaKH,TenKH,EmailKH,SdtKH);
		String errorString=null;
		if (errorString==null) {
			try {
				khachhangDBUtils.insertKhachhang(conn, khachhang);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("khachhang", khachhang);		
		response.sendRedirect(request.getContextPath()+"/Danh-sach-khach-hang");
	}
}
