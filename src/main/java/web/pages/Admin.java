package web.pages;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.NoOrdreExist;
import cupcakeMaster.domain.order.Ordre;
import cupcakeMaster.domain.order.OrdreLinie;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/Admin")
public class Admin extends BaseServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HashMap<Integer, List<OrdreLinie>> openordersandlines=null;
            try {
              openordersandlines= api.findOpenOrdersAndOrdreLines();
            } catch (NoOrdreExist noOrdreExist) {
                noOrdreExist.printStackTrace();
            }
            List<Ordre> orders=api.findOpenOrders();
            req.setAttribute("Orders",orders);
            List<LocalDate> pickupdates=new ArrayList<>();
            List<String>emails=new ArrayList<>();
            List<Integer>quantitys=new ArrayList<>();
            List<Integer>prices=new ArrayList<>();
            for (Ordre ordre :orders ) {
                LocalDate pickUPDate=ordre.getDate().plusDays(1);pickupdates.add(pickUPDate);
                String email="gfnslnfl";emails.add(email);
                Integer quantity=0;
                Integer price=0;
                for (OrdreLinie ordreLinie:openordersandlines.get(ordre.getOrdre_id())){
                    quantity=quantity+ordreLinie.getQuantity();
                    price=price+ordreLinie.getOrdrelinieSum();
                }
                quantitys.add(quantity);
                prices.add(price);
            }
            req.setAttribute("pickupdate",pickupdates);
            req.setAttribute("email",emails);
            req.setAttribute("quantity",quantitys);
            req.setAttribute("price",prices);

            render("Cupcake", "/WEB-INF/pages/admin.jsp", req, resp );
        }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("delete")!=null){
            int orderToDelete=Integer.parseInt(req.getParameter("delete"));
            api.deleteOrder(orderToDelete);
            resp.sendRedirect(req.getContextPath() + "/Admin");

        }

        }


    }
