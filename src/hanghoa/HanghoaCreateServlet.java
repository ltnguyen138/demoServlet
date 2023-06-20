package hanghoa;

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


@WebServlet("/Them-moi-hang-hoa")
public class HanghoaCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HanghoaCreateServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/hanghoaCreateView.jsp");
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaHHStr=(String) request.getParameter("maHH");
		String TenHH=(String) request.getParameter("tenHH");
		String MaNCCStr=(String) request.getParameter("maNCC");
		String soluongStr=(String) request.getParameter("soluong");
		String DonGiaStr=(String) request.getParameter("donGia");
		int MaNCC=0;
		int MaHH=0;
		int soluong=0;
		float DonGia=0;
		try {
			MaHH=  Integer.parseInt(MaHHStr);
			MaNCC=  Integer.parseInt(MaNCCStr);
			soluong=  Integer.parseInt(soluongStr);
			DonGia=  Float.parseFloat(DonGiaStr);
		}catch (Exception e) {
		}
		
		hanghoa hanghoa= new hanghoa(MaHH,TenHH,MaNCC,soluong,DonGia);
		String errorString=null;
		if (errorString==null) {
			try {
				hanghoaDBUtils.insertHanghoa(conn, hanghoa);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("hanghoa", hanghoa);
		
		response.sendRedirect(request.getContextPath()+"/Danh-sach-hang-hoa");
	}
	

}
