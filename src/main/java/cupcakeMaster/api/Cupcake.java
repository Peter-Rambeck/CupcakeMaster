package cupcakeMaster.api;

import cupcakeMaster.domain.order.*;


public class Cupcake {

    private static final String VERSION = "0.1";
    private final OrderListRepository orderlists;

    public Cupcake(OrderListRepository orderlists) {
        this.orderlists = orderlists;
    }


    public String getVersion() {
        return VERSION;
    }

}





