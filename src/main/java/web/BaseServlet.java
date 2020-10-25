package web;

import cupcakeMaster.api.Cupcake;
import cupcakeMaster.infrastructure.DBOrderlistRepository;
import cupcakeMaster.infrastructure.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BaseServlet extends HttpServlet {

    protected static final Cupcake api;

    static {
        api = createCupcake();
    }

    private static Cupcake createCupcake(){
        Database db = new Database();
        return new Cupcake(new DBOrderlistRepository(db));
    }


    protected void setup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
    }


    protected void render(String title, String content, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("version", api.getVersion());
        req.setAttribute("title", title);
        req.setAttribute("content", content);
        req.getRequestDispatcher("/WEB-INF/base.jsp").forward(req, resp);

    }

}
