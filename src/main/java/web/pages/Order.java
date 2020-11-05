package web.pages;
import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.NoOrdreExist;
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

@WebServlet({"/order", "/order/*"})
public class Order extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var s = req.getSession();
        Ordre order;
        List<OrdreLinie> ordreLinies;
        int order_ID=0;
        if(s.getAttribute("orderID")!=null)
        try {
            order_ID= (int) s.getAttribute("orderID");
            if(s.getAttribute("orderID")!=null){ order_ID= (int) s.getAttribute("orderID");}
            order=api.findOrdre(order_ID);
            ordreLinies=api.findOrdreLinierFromOrdreID(order_ID);
            req.setAttribute("orderID",order_ID);
            req.setAttribute("orderDate",order.getDate());
            Customer customer= (Customer) s.getAttribute("Customer");
            req.setAttribute("email",customer.getEmail());
            int q=0;
            int sum=0;
            for (OrdreLinie ordrelinie:ordreLinies) {
                q=q+ordrelinie.getQuantity();
                sum=sum+ordrelinie.getOrdrelinieSum();
            }
            req.setAttribute("quantity",q);
            req.setAttribute("price",sum);
            req.setAttribute("pickupDate",order.getDate().plusDays(1));


        } catch (DBException e) {

            resp.sendRedirect(req.getContextPath() + "/shoppingCart");
//            e.printStackTrace();
        } catch (NoOrdreExist noOrdreExist) {
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");

           // noOrdreExist.printStackTrace();
        }catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");

            // noOrdreExist.printStackTrace();
        }


        render("Cupcake", "/WEB-INF/pages/order.jsp", req, resp );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var s = req.getSession();
        s.setAttribute("orderID",null);
        resp.sendRedirect(req.getContextPath() + "/shoppingCart");

    }
}