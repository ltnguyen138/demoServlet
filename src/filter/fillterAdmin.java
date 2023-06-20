package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/Danh-sach-nhan-vien","/Them-moi-nhan-vien","/Xoa-nhan-vien","/Cap-nhat-nhan-vien"})
public class fillterAdmin extends HttpFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	}
    public fillterAdmin() {
        super();
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res =(HttpServletResponse) response;
		HttpServletRequest req =(HttpServletRequest) request;
		String url=req.getRequestURI();
		System.out.print(url);
		HttpSession session=(HttpSession) req.getSession();
		Object objRole=session.getAttribute("role");
		String role= (String)objRole;
		System.out.print("ssss"+role);
		if(role.equals("admin") ) {

			chain.doFilter(request, response);	
		}
		else {
			RequestDispatcher dispatcher=req.getServletContext().getRequestDispatcher("/thongbao.jsp");
			dispatcher.forward(request, response);
		}
	}
	public void destroy() {
	}
}
