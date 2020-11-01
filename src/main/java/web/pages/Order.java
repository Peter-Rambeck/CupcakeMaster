package web.pages;

import cupcakeMaster.api.Cupcake;
import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.OrdreLinie;
import cupcakeMaster.infrastructure.*;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static web.pages.ShoppingCart.getShoppingCart;

@WebServlet({"/order", "/order/*"})
public class Order extends BaseServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrdreLinie> ordrelinier = new ArrayList<>();
        req.getAttribute("ordrelinier");// liste af ordrelinier
        String email = req.getParameter("email");//-------------
        LocalDate date = (LocalDate) req.getAttribute("date");
        render("Cupcake", "/WEB-INF/pages/order.jsp", req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        List<OrdreLinie> orders = ShoppingCart.getShoppingCart(req);
        /// save to database
        int orderId = 0; //...
        // get order id

         */

    }
}
