package ncc;

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

@WebServlet("/Them-moi-nha-cung-cap")
public class NccCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NccCreateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/nccCreateView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = MySQLConnection.getMySQLConnection();
		String MaNCCStr=(String) request.getParameter("maNCC");
		String TenNCC=new String(request.getParameter("tenNCC").getBytes("iso-8859-1"), "utf-8");
		String EmailNCC=(String) request.getParameter("emailNCC");
		String DiaChiNCC=(String) request.getParameter("diaChiNCC");
		String SdtNCC=(String) request.getParameter("sdtNCC");
		int MaNCC=0;
		try {
			MaNCC=  Integer.parseInt(MaNCCStr);
		}catch (Exception e) {
		}	
		ncc ncc= new ncc(MaNCC,TenNCC,EmailNCC,DiaChiNCC,SdtNCC);
		String errorString=null;
		if (errorString==null) {
			try {
				nccDBUtils.insertNcc(conn, ncc);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
				errorString=e.getMessage();
			}
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("ncc", ncc);
		response.sendRedirect(request.getContextPath()+"/Danh-sach-nha-cung-cap");
	}
}
