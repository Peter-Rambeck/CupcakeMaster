package web.pages;

import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/customerpage")
    public class Customerpage extends BaseServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                ServletException, IOException {
            render("Kunde", "/WEB-INF/pages/customerpage.jsp", req, resp );
        }
    }

