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
        var s = req.getSession();
        Customer customer= (Customer) s.getAttribute("Customer");
        if((customer!=null)&&(customer.isAdmin())){
             render("Cupcake", "/WEB-INF/pages/customers.jsp", req, resp );}
        else {
            render("Cupcake", "/WEB-INF/pages/index.jsp", req, resp );}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int paid = Integer.parseInt(req.getParameter("paid"));
            int custuomerId = Integer.parseInt(req.getParameter("customer_id"));
            api.updateSaldo(custuomerId, paid);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        resp.sendRedirect(req.getContextPath() + "/Customers");

    }
}
