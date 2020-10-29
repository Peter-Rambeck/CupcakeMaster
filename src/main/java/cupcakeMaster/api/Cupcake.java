package cupcakeMaster.api;

import cupcakeMaster.domain.order.*;


public class Cupcake {

    private static final String VERSION = "0.1";
    private final OrdreLinieRepository orderlists;
    private final BottomRepository bottoms;
    private final TopRepository tops;

    public Cupcake(OrdreLinieRepository orderlists, BottomRepository buttoms, TopRepository tops) {
        this.orderlists = orderlists;
        this.bottoms = buttoms;
        this.tops = tops;
    }

    public String getVersion() {
        return VERSION;
    }

    public Iterable<Top> allTops() {
        try {
            return tops.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
    }

    public Iterable<Bottom> allBottoms() {
        try {
            return bottoms.findAll();
        } catch (DBException e) {
            throw new RuntimeException(e);
        }
}

    public Top findTop(int parseInt) throws DBException {
        return tops.find(parseInt);
    }

    public Bottom findBottom(int parseInt) throws DBException {
        return bottoms.find(parseInt);
    }
}





