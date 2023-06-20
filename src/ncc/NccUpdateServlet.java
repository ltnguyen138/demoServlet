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


@WebServlet("/Cap-nhat-nha-cung-cap")
public class NccUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
   
    public NccUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		HttpSession session=(HttpSession) request.getSession();
		Object objUsername=session.getAttribute("username");
		request.setAttribute("name", objUsername);
		String MaNCCStr=(String) request.getParameter("MaNCC");
		int MaNCC=0;
		MaNCC=  Integer.parseInt(MaNCCStr);
		ncc ncc =null;
		String errorString=null;
		try {
			ncc=nccDBUtils.findNcc(conn,MaNCC);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		
		if (errorString!=null&& ncc==null) {
			response.sendRedirect(request.getServletPath()+"/Danh-sach-nha-cung-cap");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("ncc", ncc);
		RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editNccView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		try {
			nccDBUtils.updateNcc(conn, ncc);
		}catch(SQLException e) {
			e.printStackTrace();
			errorString=e.getMessage();
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("ncc", ncc);
		
		if(errorString!=null) {
			RequestDispatcher dispatcher=request.getServletContext().getRequestDispatcher("/editNccView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/Danh-sach-nha-cung-cap");
		}
	}
}
