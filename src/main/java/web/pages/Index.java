package web.pages;
import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.OrdreLinie;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class Index extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        render("Cupcake", "/WEB-INF/pages/index.jsp", req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("target").equals("shoppingCart")) {
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");
        }

    }
}