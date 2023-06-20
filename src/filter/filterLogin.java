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

@WebFilter(urlPatterns = {"/Danh-sach-hang-hoa","/Cap-nhat-hang-hoa","/Xoa-hang-hoa","/Them-moi-hang-hoa","/",
		"/Them-moi-chi-tiet-phieu-nhap","/Xoa-chi-tiet-phieu-nhap","/Danh-sach-chi-tiet-phieu-nhap","/Cap-nhat-chi-tiet-phieu-nhap",
		"/Them-moi-phieu-nhap","/Xoa-phieu-nhap","/Danh-sach-phieu-nhap","/Cap-nhat-phieu-nhap",
		"/Them-moi-chi-tiet-phieu-xuat","/Xoa-chi-tiet-phieu-xuat","/Danh-sach-chi-tiet-phieu-xuat","/Cap-nhat-chi-tiet-phieu-xuat",
		"/Them-moi-phieu-xuat","/Xoa-phieu-xuat","/Danh-sach-phieu-xuat","/Cap-nhat-phieu-xuat",
		"/Them-moi-hoa-don","/Xoa-hoa-don","/Danh-sach-hoa-don","/Cap-nhat-hoa-don",
		"/Them-moi-khach-hang","/Xoa-khach-hang","/Danh-sach-khach-hang","/Cap-nhat-khach-hang",
		"/Danh-sach-nhan-vien","/Them-moi-nhan-vien","/Xoa-nhan-vien","/Cap-nhat-nhan-vien",
		"/Them-moi-nha-cung-cap","/Xoa-nha-cung-cap","/Danh-sach-nha-cung-cap","/Cap-nhat-nha-cung-cap"})
public class filterLogin extends HttpFilter implements Filter {
       
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
    public filterLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res =(HttpServletResponse) response;
		HttpServletRequest req =(HttpServletRequest) request;
		String url=req.getRequestURI();
		System.out.print(url);
		HttpSession session=(HttpSession) req.getSession();
		Object objUsername=session.getAttribute("username");
		System.out.print(objUsername);
		if(objUsername!=null ) {
			chain.doFilter(request, response);	
		}
		else {
			RequestDispatcher dispatcher=req.getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}	
	}
	public void destroy() {
	}

	

}
