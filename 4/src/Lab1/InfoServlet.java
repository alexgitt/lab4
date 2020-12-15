package Lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Language", "ru");
        req.setAttribute("name", req.getParameter("name"));
        req.setAttribute("date", req.getAttribute("date"));
        req.setAttribute("count", req.getAttribute("count"));
        req.getRequestDispatcher("/info.jsp").forward(req, resp);
    }


}
