package web.pages;

import cupcakeMaster.api.Cupcake;
import cupcakeMaster.domain.order.*;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.infrastructure.*;
import web.BaseServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
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
        try {
            System.out.println("size of map" + api.findOpenOrdersAndOrdreLines().size());
        } catch (NoOrdreExist noOrdreExist) {
            noOrdreExist.printStackTrace();
        }
        render("Bestilling", "/WEB-INF/pages/shoppingCart.jsp", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //tilføj ordrelinie til shoppingcart
        if (req.getParameter("target") != null)
            if (req.getParameter("target").equals("shoppingCart")) {
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

        //login er trykket
        if (req.getParameter("Loginemail")!=null) {
            String email = req.getParameter("Loginemail");
            String password = req.getParameter("Loginpassword");
            Customer customer = api.findCustomer(email);
            if(customer!=null) {
                boolean correctpassword = customer.checkPassword(password);
                if (correctpassword) {
                    var s = req.getSession();
                    s.setAttribute("Customer", customer);

                }

            }
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");

        }

        //logout
        if (req.getParameter("logout")!=null) {
            var s = req.getSession();
            s.setAttribute("Customer",null);
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");

        }

        // sign up....customer oprettes og role blievr sat til customer
        // hvs email=2admin@admin.dk" sættes role til admin
        if (req.getParameter("email") != null) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            byte [] salt= Customer.generateSalt();
            byte [] secret = Customer.calculateSecret(salt, password);
            boolean admin = false;
            if (email.equals("admin@admin.dk")) {
               admin = true;
           }
            Customer customer = new Customer(email,0, admin, salt, secret);
            try {
                customer = api.commitCustomer(customer);
                var s = req.getSession();
                s.setAttribute("Customer",customer);
            } catch (DBException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/shoppingCart");
        }

            // bestil det der er i shoppingcart....gøres kun hvis nogen er logget ind
            if (req.getParameter("target") != null)
                if (req.getParameter("target").equals("bestil")) {
                    int ordre_id = 0;
                    var s = req.getSession();
                    Customer customer = (Customer) s.getAttribute("Customer");
                    if (customer != null) {
                        try {

                            int customer_id = customer.getCustomerId();
                            ordre_id = api.commitShoppingCart(getShoppingCart(req), LocalDate.now(), customer_id);
                            api.updateSaldo(customer_id, -api.getPrice(ordre_id));
                        } catch (DBException e) {
                            e.printStackTrace();
                        }
                        s.setAttribute("orderID", ordre_id);
                        s.setAttribute("shoppingCart", null);
                        resp.sendRedirect(req.getContextPath() + "/order");
                    } else {
                        resp.sendRedirect(req.getContextPath() + "/shoppingCart");
                    }
                }

            // delete valgte ordrlinie i shoppingcart
            if (req.getParameter("delete") != null) {
                int lineToDelete = Integer.parseInt(req.getParameter("delete"));
                getShoppingCart(req).remove(lineToDelete);
                resp.sendRedirect(req.getContextPath() + "/shoppingCart");

            }
        }
    }

