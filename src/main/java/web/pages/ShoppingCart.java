package web.pages;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.infrastructure.DBTopRepository;
import cupcakeMaster.infrastructure.Database;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shoppingCart")
public class ShoppingCart extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Database db = new Database();
        DBTopRepository topRepository = new DBTopRepository(db);
                try {
            req.setAttribute("topping", topRepository.findAll());
            req.setAttribute("bottom",topRepository.findAll());
        } catch (DBException e) {
            e.printStackTrace();
        }
        render("Bestilling", "/WEB-INF/pages/shoppingCart.jsp", req, resp );

    }
}
