package web.pages;

import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/lists", "/lists/*"})
public class Lists extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setup(req, resp);
        if (req.getPathInfo() == null) {
            render("Hejsa", "/WEB-INF/pages/shoppingCard.jsp", req, resp);
        } else {
            int orderlistid = Integer.parseInt(req.getPathInfo().substring(1));
            // log(req, "Accessing Order List " + orderlistid);
            // OrderList orderList = api.findOrderList(orderlistid);
            // req.setAttribute("list", orderList);
            render("Cupcake order: ","/WEB-INF/pages/shoppingCart.jsp", req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        setup(req, resp);
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        if (name == null || name.equals("")) {
            resp.sendError(400, "Expected a name of the shopping list");
        } else {
            // OrderList list = api.createOrderList(name, description);
            // resp.sendRedirect(req.getContextPath() + "/lists/" + list.getId());
        }
    }
}
