package cupcakeMaster.domain.Login;

import cupcakeMaster.domain.order.DBException;
import cupcakeMaster.domain.order.customer.Customer;
import cupcakeMaster.domain.order.customer.CustomerNotFoundException;
import cupcakeMaster.domain.order.customer.CustomerRepository;
import cupcakeMaster.infrastructure.DBBottomRepository;
import cupcakeMaster.infrastructure.DBTopRepository;
import cupcakeMaster.infrastructure.Database;
import web.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends BaseServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //Database db = new Database();


        render("Login", "/WEB-INF/pages/login.jsp", req, resp);


            }

}
