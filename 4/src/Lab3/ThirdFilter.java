package Lab3;

import javax.servlet.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class ThirdFilter implements javax.servlet.Filter {

    private Logger logger;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger = Logger.getLogger("Logger");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Content-language: " + "en");
    servletRequest.setAttribute("source", "sun.jpg");
    servletRequest.setAttribute("backgroundColor", "#FFF");
    servletRequest.setAttribute("textColor", "black");
    filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}