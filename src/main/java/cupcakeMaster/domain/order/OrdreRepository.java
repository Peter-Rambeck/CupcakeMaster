package cupcakeMaster.domain.order;

import java.time.LocalDate;
import java.util.List;

public interface OrdreRepository {






    Iterable<Ordre> findAll();
    Ordre find(int id) throws NoOrdreExist;
    public int commit(Ordre ordre,int ordre_id) throws DBException;
}
