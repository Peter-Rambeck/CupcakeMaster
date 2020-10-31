package cupcakeMaster.domain.order;


import java.time.LocalDate;
import java.util.List;

public interface OrdreLinieRepository {

    Iterable<OrdreLinie> findAll();
    OrdreLinie find(int id) throws NoOrdreLinieExist;
    public int commit(OrdreLinie ordreLinie, int ordre_id) throws DBException;
    public int commitShoppingCart(List<OrdreLinie> ordreLinier,  LocalDate dato, int customer_id ) throws DBException;
}
