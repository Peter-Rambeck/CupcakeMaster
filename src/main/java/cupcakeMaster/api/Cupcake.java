package cupcakeMaster.api;

import cupcakeMaster.domain.order.*;


public class Cupcake {

    private static final String VERSION = "0.1";
    private final OrdreLinieRepository orderlists;

    public Cupcake(OrdreLinieRepository orderlists) {
        this.orderlists = orderlists;
    }


    public String getVersion() {
        return VERSION;
    }

}





