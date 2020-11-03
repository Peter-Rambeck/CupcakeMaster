package web.pages;

import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Customers")
public class Customers extends BaseServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
                ServletException, IOException {
            render("Cupcake", "/WEB-INF/pages/customers.jsp", req, resp );
        }
    }

