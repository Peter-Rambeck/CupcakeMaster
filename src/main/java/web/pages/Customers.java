package web.pages;

import cupcakeMaster.domain.order.Ordre;
import cupcakeMaster.domain.order.OrdreLinie;
import cupcakeMaster.domain.order.customer.Customer;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Customers")
public class Customers extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
         req.setAttribute("customers", api.findAll());

        render("Cupcake", "/WEB-INF/pages/customers.jsp", req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // int paid = Integer.parseInt(req.getParameter("value"));
       // int custuomerId = Integer.parseInt(req.getParameter("name"));

        String value=req.getParameter("value");
        String name=req.getParameter("paid" +
                "");

        System.out.println(value);
        System.out.println(name);

        resp.sendRedirect(req.getContextPath() + "/Customers");


    }
}
