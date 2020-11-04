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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/Admin")
public class Admin extends BaseServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            var s = req.getSession();
            Customer customer= (Customer) s.getAttribute("Customer");

            if(s.getAttribute("orderToShow")==null)
            s.setAttribute("orderToShow",0);

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
            if((customer!=null)&& (customer.isAdmin())){
                 render("Cupcake", "/WEB-INF/pages/admin.jsp", req, resp );}
            else {
                 render("Cupcake", "/WEB-INF/pages/index.jsp", req, resp );}

        }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("delete")!=null){
            int orderToDelete=Integer.parseInt(req.getParameter("delete"));
            api.deleteOrder(orderToDelete);
            resp.sendRedirect(req.getContextPath() + "/Admin");
        }

        if(req.getParameter("afslut")!=null){
            int orderToClose=Integer.parseInt(req.getParameter("afslut"));
            Ordre ordre=null;
            Customer customer=null;
            try {
                ordre=api.findOrdre(orderToClose);
                List<OrdreLinie> ordreLinier=api.findOrdreLinierFromOrdreID(orderToClose);
                int price=0;
                for (OrdreLinie ordreLinie :ordreLinier) {
                    price=price+ordreLinie.getOrdrelinieSum();
                }


                api.updateSaldo(ordre.getCustomer_id(),price);

            } catch (DBException e) {
                e.printStackTrace();
            } catch (NoOrdreExist noOrdreExist) {
                noOrdreExist.printStackTrace();
            }

            api.closeOrder(orderToClose);
            resp.sendRedirect(req.getContextPath() + "/Admin");
        }

        if(req.getParameter("vis")!=null){
            int orderToShow=Integer.parseInt(req.getParameter("vis"));
            var s = req.getSession();
            HashMap<Integer, List<OrdreLinie>> openOrdersAndOrdreLines=null;
            try {
                openOrdersAndOrdreLines = api.findOpenOrdersAndOrdreLines();
            } catch (NoOrdreExist noOrdreExist) {
                noOrdreExist.printStackTrace();
            }
            s.setAttribute("orderToShow",orderToShow);
            s.setAttribute("orderlinestoshow",openOrdersAndOrdreLines.get(orderToShow));
            resp.sendRedirect(req.getContextPath() + "/Admin");

        }

        }


    }
