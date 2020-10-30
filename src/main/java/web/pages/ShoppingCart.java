package web.pages;

import cupcakeMaster.domain.order.*;
import cupcakeMaster.infrastructure.DBBottomRepository;
import cupcakeMaster.infrastructure.DBTopRepository;
import cupcakeMaster.infrastructure.Database;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/shoppingCart")
public class ShoppingCart extends BaseServlet {

    public static List<OrdreLinie> getShoppingCart(HttpServletRequest req) {
        var s = req.getSession();
        List<OrdreLinie> shoppingCart = (List<OrdreLinie>) s.getAttribute("shoppingCart");
        if (shoppingCart == null) {
            shoppingCart = new ArrayList<>();
            s.setAttribute("shoppingCart", shoppingCart);
        }
        return shoppingCart;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        getShoppingCart(req);
        req.setAttribute("topping", api.allTops());
        req.setAttribute("bottom", api.allBottoms());
        render("Bestilling", "/WEB-INF/pages/shoppingCart.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        String topping = req.getParameter("topping");
        String bottom = req.getParameter("bottom");

        try {
            OrdreLinie ordreLinie = new OrdreLinie(Integer.parseInt(number), 0,
                    api.findTop(Integer.parseInt(topping)),
                    api.findBottom(Integer.parseInt(bottom)));
            getShoppingCart(req).add(ordreLinie);
        } catch (DBException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/shoppingCart");


    }
}
