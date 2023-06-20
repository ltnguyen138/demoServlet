package user;

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


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = MySQLConnection.getMySQLConnection();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		user user =null;
		boolean hasError=false;
		String errorString=null;
		if(username==null||password==null||username.length()==0||password.length()==0) {
			hasError=true;
			errorString="Vui long nhap du username va password";
		}
		else {
			try {
				user=userDBUtils.findUser(conn, username, password);
				if(user==null) {
					hasError=true;
					errorString="username hoac mat khau khong dung";
				}
			}catch(SQLException e) {
				e.printStackTrace();
				hasError=true;
				errorString=e.getMessage();
			}
			
		}
		if(hasError) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);					
		}
		else {
			HttpSession session=request.getSession();
			request.getSession().setAttribute("username",username);
			request.getSession().setAttribute("role", user.getRole());
			request.getSession().setAttribute("id", user.getId());
			response.sendRedirect("Danh-sach-hang-hoa");
		}
	}

}
