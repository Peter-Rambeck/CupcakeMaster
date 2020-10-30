package web.pages;

import cupcakeMaster.domain.order.OrdreLinie;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/order", "/order/*"})
public class Order extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrdreLinie> orders = ShoppingCart.getShoppingCart(req);
        /// save to database
        int orderId = 0; //...
        // get order id
        resp.sendRedirect(req.getContextPath() + "/order/" + orderId);
    }
}
