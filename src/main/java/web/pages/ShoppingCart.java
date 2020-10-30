package web.pages;

import cupcakeMaster.api.Cupcake;
import cupcakeMaster.domain.order.*;
import cupcakeMaster.infrastructure.*;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
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
       if(req.getParameter("target").equals("shoppingCart")) {
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
        if(req.getParameter("target").equals("bestil")) {
            Database db = new Database();
            Cupcake cupcake= new Cupcake(new DBOrdreLinieRepository(db), new DBBottomRepository(db), new DBTopRepository(db),new DBCustomerRepository(db));
            try {
                cupcake.commitShoppingCart(getShoppingCart(req), LocalDate.now(),1);//-----------
            } catch (DBException e) {
                e.printStackTrace();
            }
            req.setAttribute("ordrelinier",getShoppingCart(req));// liste af ordrelinier
            req.setAttribute("email","test@gmail");//-------------
            req.setAttribute("date",LocalDate.now());


            resp.sendRedirect(req.getContextPath() + "/order");
        }
    }
}
