package Lab2;

import javax.servlet.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SecondFilter implements javax.servlet.Filter {

    Calendar calendar;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        if (servletRequest.getAttribute("time") != null) {
            calendar = (Calendar) servletRequest.getAttribute("time");
        } else {
            calendar = new GregorianCalendar();
        }

//        calendar.set(Calendar.HOUR_OF_DAY, Calendar.HOUR_OF_DAY + 12);
        if (calendar.get(Calendar.HOUR_OF_DAY) < 6 || calendar.get(Calendar.HOUR_OF_DAY) > 20) {
            servletRequest.setAttribute("source", "moon.jpg");
            servletRequest.setAttribute("backgroundColor", "black");
            servletRequest.setAttribute("textColor", "white");
        } else {
            servletRequest.setAttribute("source", "sun.jpg");
            servletRequest.setAttribute("backgroundColor", "#FFF");
            servletRequest.setAttribute("textColor", "black");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}