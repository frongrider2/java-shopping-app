package sit.int202.classicmodelweb.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",
        servletNames = {"OfficeListServlet"}
)
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session == null || session.getAttribute("user") == null) {
            response.setCharacterEncoding("UTF-8");
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,
                    "Login ก่อน นะจ๊ะ");
            return;
        } else {
            chain.doFilter(request, response);
        }
//        request.setCharacterEncoding("UTF-8");
//        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}
