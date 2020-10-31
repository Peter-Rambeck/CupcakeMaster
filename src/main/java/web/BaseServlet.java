package web;

import cupcakeMaster.api.Cupcake;
import cupcakeMaster.domain.order.*;
import cupcakeMaster.infrastructure.DBBottomRepository;
import cupcakeMaster.infrastructure.DBOrdreLinieRepository;
import cupcakeMaster.infrastructure.DBTopRepository;
import cupcakeMaster.infrastructure.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class BaseServlet extends HttpServlet {

    protected static final Cupcake api;

    static {
        api = createCupcake();
    }

    private static Cupcake createCupcake(){
        Database db = new Database();
        return new Cupcake(new DBOrdreLinieRepository(db), new DBBottomRepository(db), new DBTopRepository(db));
    }

    private static Cupcake createEmptyCupcake(){
        return new Cupcake(null, new BottomRepository() {
            List<Bottom> bottoms = List.of(new Bottom(0, "bottom", 0));

            @Override
            public Iterable<Bottom> findAll() throws DBException {
                return bottoms;
            }

            @Override
            public Bottom find(int parseInt) throws DBException {
                return bottoms.get(parseInt);
            }
        }, new TopRepository() {
            List<Top> tops = List.of(new Top(0, "top", 2));
            @Override
            public Iterable<Top> findAll() throws DBException {
                return tops;
            }

            @Override
            public Top find(int parseInt) throws DBException {
                return tops.get(parseInt);
            }
        });
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
