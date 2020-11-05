package web.pages.widgets;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class Navbar {
    private final HttpServletRequest request;

    public Navbar(HttpServletRequest request) {
        this.request = request;
    }

    public String getWebpageName() {
        return "CupcakeMaster";
    }



    public class Item {
        private final String name;
        private final String url;
        private final boolean adminOnly;

        public Item(String name, String url, boolean adminOnly) {
            this.name = name;
            this.url = url;
            this.adminOnly = adminOnly;
        }

        public String getUrl() {
            return url;
        }

        public String getName() {
            return name;
        }

        public boolean isActive() {
            return request.getRequestURI().endsWith(url);
        }
    }
}
