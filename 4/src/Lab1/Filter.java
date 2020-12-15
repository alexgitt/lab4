package Lab1;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter("/")
public class Filter implements javax.servlet.Filter {

    public int count = 0;
    Date lastDate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        count ++;
        if (count <= 1) {
            lastDate = new Date();
            servletRequest.setAttribute("date", "First coming");
        } else {
            servletRequest.setAttribute("date", lastDate);
        }
        servletRequest.setAttribute("count", count);
        servletRequest.setCharacterEncoding("windows-1251");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
